// Jenkins File for integrating all the components of CI/CD pipeline


// # Swathi Guptha - G01393328
// # Rajas Bipinchandra patil - G01393353
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

        stage('BUILD')
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
        stage('DEPLOY_DOCKER')
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
        stage('DEPLOY_KUBERNETES') 
        {
            steps
            {
                script
                {
                    sh 'pwd'
                    sh 'kubectl --kubeconfig=/home/ubuntu/.kube/config set image deployment/hw3-deployment container-1=rbptl/student-survey-backend:'+tag
                }
            }
        }

    }
}
