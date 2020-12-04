const { AwsCdkTypeScriptApp, Semver } = require('projen');

const project = new AwsCdkTypeScriptApp({
  cdkVersion: "1.73.0",
  name: "smile-jenkins",
  description: 'Jenkins Seed Files',
  authorOrganization: 'trexsolutions',
  authorName: 'T-Rex Centers of Excellence (CoE)',
  authorEmail: 'coeteam@trexsolutionsllc.com',
  repository: 'https://github.com/trexsolutions/smile-cdk.git',
  keywords: [
    'landing zones',
    'cdk',
    'security',
    'account vending machine',
    'devsecops',
    'jenkins'
  ],

  projenUpgradeSecret: 'PROJEN_GITHUB_TOKEN',
});

project.github.addMergifyRules({
  name: 'Label core contributions',
  actions: {
    label: {
      add: ['contribution/core']
    }
  },
  conditions: [
    'author~=^(pgollucci)$',
    'label!=contribution/core'
  ],
});

project.github.addMergifyRules({
  name: 'Label auto-merge for core',
  actions: {
    label: {
      add: ['auto-merge']
    }
  },
  conditions: [
    'label=contribution/core',
    'label!=auto-merge'
  ],
});

project.synth();
