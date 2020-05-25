# Contributing to T-Rex SMILE

Thanks for your interest in contributing to the T-Rex SMILE

This document describes how to set up a development environment and submit your contributions. Please read it carefully
and let us know if it's not up-to-date (even better, submit a PR with your  corrections ;-)).

- [Getting Started](#getting-started)

## Getting Started

```console
$ git clone https://github.com/trexsolutions/smile-avm.git
$ cd aws-cdk
$ make build
# make once # DO NOT RUN THAT IN PRODUCTION FOR ANY REASON EVER
```

### Visualizing dependencies in a CloudFormation Template

Use GraphViz with `template-deps-to-dot`:

```shell
$ cdk -a some.app.js synth | $smile/scripts/template-deps-to-dot | dot -Tpng > deps.png
```

### Connecting the VS Code Debugger

Add the following launch configuration to the settings file -

  ```json
  "launch": {
    "configurations": [{
      "type": "node",
      "request": "launch",
      "name": "Debug smile-avm",
      "program": "${workspaceFolder:hello-cdk}/bin/smile-avm.js",
      "cwd": "${workspaceFolder:smile-avm}",
      "console": "internalConsole",
      "sourceMaps": true,
      "skipFiles": [ "<node_internals>/**/*" ],
      "outFiles": [
        "${workspaceFolder:smile-avm}/**/*.js",
      ],
    }]
  }
  ```

  *Go [here](https://code.visualstudio.com/docs/editor/debugging#_launch-configurations) for more about launch configurations.*

The debug view, should now have a launch configuration called 'Debug smile-avm' and launching that will start the debugger.
