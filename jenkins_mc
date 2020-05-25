def awsCredentials = [[$class: 'AmazonWebServicesCredentialsBinding', credentialsId: 'smile-aws']]

pipeline {
  
  agent any

  parameters {
      string(name: 'filename', defaultValue: 'test/smile-mulit-account.yml', description: 'Name of Smile config file.')      
      string(name: 'account', defaultValue: '404038189289 118243639176', description: 'New account numbers.')
  }

  options {
    disableConcurrentBuilds() 
    timestamps()
  }

  tools {nodejs "AWS-CDK"}

  stages { 
    stage('Node Modules') {
      steps {
        sh 'node -v'
        sh 'npm -v'
        sh 'npm install typescript -g'
        sh 'npm i -g aws-cdk'        
        sh 'npm install @aws-cdk/core -g'
        sh 'npm install js-yaml -g'
        sh 'npm install @types/js-yaml'
        sh 'cdk --version' 
        sh 'npm update'
      }
    } 

    stage('Build') {
      steps {
        sh 'npm run build'
      }
    } 

    stage('Copy Config') {
      steps {
        withAWS() {
          s3Download(file: "smile.yml", bucket: "trex-smile-dev", path: "${params.filename}", force:true)
        }
      } 
    } 

    stage('Deploy') {
      steps { 
        withEnv(["SMILEACCOUNTS=${params.account}"]) {
          sh '''#!/bin/bash 

                #set -x
                                
                echo "SMILEACCOUNTS========================================="
                echo $SMILEACCOUNTS

                for SMILEACCOUNT in $SMILEACCOUNTS; do
                    echo "BEGIN FOR LOOP ========================================="              

                    unset AWS_ACCESS_KEY_ID AWS_SECRET_ACCESS_KEY AWS_SESSION_TOKEN AWS_SECURITY_TOKEN SMILE_ACCOUNT

                    # AWS Organizations seeds the account with a role assumable by root account
                    ROLE="${1:-OrganizationAccountAccessRole}"
                    ACCOUNT=$SMILEACCOUNT
                    DURATION="${3:-900}"
                    NAME="${4:-$LOGNAME@`hostname -s`}"

                    KST=($(/home/tomcat/.local/bin/aws sts assume-role --role-arn "arn:aws:iam::$ACCOUNT:role/$ROLE" \
                                            --role-session-name "$NAME" \
                                            --duration-seconds $DURATION \
                                            --query '[Credentials.AccessKeyId,Credentials.SecretAccessKey,Credentials.SessionToken]' \
                                            --output text))

                    export AWS_DEFAULT_REGION=${AWS_DEFAULT_REGION:-us-east-1}
                    export AWS_ACCESS_KEY_ID=${KST[0]}
                    export AWS_SECRET_ACCESS_KEY=${KST[1]}
                    export AWS_SESSION_TOKEN=${KST[2]}
                    export AWS_SECURITY_TOKEN=${KST[2]}
                    export SMILE_ACCOUNT=$SMILEACCOUNT
                    
                    echo "Smile Account Number" 
                    echo $SMILEACCOUNT
                    echo "AWS_DEFAULT_REGION:" 
                    echo $AWS_DEFAULT_REGION
                    echo "AWS_ACCESS_KEY_ID:"
                    echo $AWS_ACCESS_KEY_ID

                    cfcntr=0
                    echo "Waiting for CF Service ..."
                    sleep 1

                    #Synth
                    echo "bash cdk SYNTH"
                    cdk synth

                    #Deploy
                    echo "bash cdk DEPLOY"
                    cdk deploy SmileMultiAccountStack* --require-approval=never
                    
                    #Tear down during testing
                    echo "bash cdk END DEPLOY"
                 
                    #cdk destroy SmileMultiAccountStack* --force

                done
              '''
        }
      }
    }
  }
}