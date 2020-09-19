folder('smile') {
	displayName('Smile')
	description('Folder for Smile')
}
/*
folder('smile/avm') {
	displayName('AVM')
	description('Folder for the Account Vending Machine')
}
folder('smile/lz') {
	displayName('LZ')
	description('Folder for Landing Zones')
}
*/
folder('smile/container') {
	displayName('Container')
	description('Folder for Landing Zones')
}

pipelineJob('smile/container/build_tag_push') {
	displayName('Smile Container Build, Tag, & Push')
	description('Builds Dockerfile & Pushes to ECR')
	definition {
            	git {
                	remote {
                		url('https://github.com/trexsolutions/smile-cdk.git')
                    }
                    branches('*/master')
                }
            }
            scriptPath('pipelines/container/build_tag_push.groovy')
        }
	}
}

