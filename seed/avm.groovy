folder('smile') {
	displayName('Smile')
	description('Folder for Smile')
}
folder('smile/avm') {
	displayName('AVM')
	description('Folder for the Account Vending Machine')
}
folder('smile/lz') {
	displayName('AVM')
	description('Folder for Landing Zones')
}

pipelineJob('smile/avm/create') {
	displayName('Smile AVM Account Create')
	description('Creates a new Account in the Organization')
}
pipelineJob('smile/avm/delete') {
	displayName('Smile AVM Account Delete')
	description('Removes account from the Organization')
}
pipelineJob('smile/avm/provision') {
	displayName('Smile AVM Account Provision')
	description('Provisions an account')
}

pipelineJob('smile/lz/create') {
	displayName('Smile Landing Zone Create')
	description('Creates a Landing Zone')
}
pipelineJob('smile/lz/delete') {
	displayName('Smile Landing Zone Delete')
	description('Deletes a Landing Zone')
}
