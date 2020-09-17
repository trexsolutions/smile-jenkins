folder('smile') {
  displayName('Smile')
  description('Folder for Smile')
}

folder('smile/avm') {
  displayName('AVM')
  description('Folder for Account Vending Machine')
}

pipelineJob('smile/avm/create') {
	displayName('Smile AVM Account Create')
    description('Creates a new Account in the Organization')
}
