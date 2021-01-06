const { AwsCdkTypeScriptApp } = require('projen');

/**
 * An AWS CDK TypeScript Application
 * Applications unlike Constructs can be directly deployed
 */
const project = new AwsCdkTypeScriptApp({
  /**
   * The master cdk version
   * https://github.com/projen/projen/blob/master/API.md#struct-awscdktypescriptappoptions--
   */
  cdkVersion: '1.82.0',
  name: 'smile-jenkins',
  description: 'Seed Jobs',
  authorOrganization: 'trexsolutions', // This must match the NPMJS organization
  authorName: 'T-Rex Centers of Excellence (CoE)',
  authorEmail: 'coeteam@trexsolutionsllc.com',
  repository: 'https://github.com/trexsolutions/smile-jenkins.git',
  keywords: [
    'jenkins',
  ],

  // XXX: need to add this secret in GitHub
  projenUpgradeSecret: 'PROJEN_GITHUB_TOKEN',
  codeCov: true,
  // docgen: true,
  gitpod: true,
});

project.gitignore.exclude('.tools');

/**
 * Label pgollucci PR as contribution/core which is common in OSS
 */
project.github.addMergifyRules({
  name: 'Label core contributions',
  actions: {
    label: {
      add: ['contribution/core'],
    },
  },
  conditions: [
    'author~=^(pgollucci)$',
    'label!=contribution/core',
  ],
});

/**
 * Until more than one person, auto-merge core PRs if CI passes
 */
project.github.addMergifyRules({
  name: 'Label auto-merge for core',
  actions: {
    label: {
      add: ['auto-merge'],
    },
  },
  conditions: [
    'label=contribution/core',
    'label!=auto-merge',
  ],
});

/**
 * Write it to the directory
 */
project.synth();
