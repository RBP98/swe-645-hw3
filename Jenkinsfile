// Jenkins File for integrating all the components of CI/CD pipeline


// # Swathi Guptha - G01393328
// # Rajas Bipinchandra Patil - G01393353
// # Poorvi Lakkadi - G01389351


/* groovylint-disable-next-line CompileStatic */
@NonCPS
def generateTag() {
    return "build-" + new Date().format("yyyyMMdd-HHmmss")
}

pipeline{
    environment
    {
        registry = "rbptl/student-survey-backend"
        registryCredential = "docker-login"
    }
    agent any
    
    tools
    {
        maven 'Maven'
    }
    stages
    {

        stage('Build')
        {
            steps
            {
                script
                {
		    sh 'whoami'
		    sh 'rm -rf *.jar'
                    sh 'mvn clean package'
		    sh 'echo ${BUILD_TIMESTAMP}'
                    tag = generateTag()
                    image = docker.build("rbptl/student-survey-backend:"+tag)
                }
            }
        }
        stage('deploy docker image')
        {
            steps
            {
                script
                {
                    docker.withRegistry('',registryCredential)
                    {
                        image.push()
                    }
                }
            }
        }
        stage('Deploying Rancher to single nodes') 
        {
            steps
            {
                script
                {

                    sh 'pwd'
                    sh 'kubectl --kubeconfig=/home/ubuntu/.kube/config set image deployment/student-survey-backend-deployment container-1=rbptl/student-survey-backend:'+tag
                }
            }
        }

    }
}
