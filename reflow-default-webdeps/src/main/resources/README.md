# Generate local dependencies

## Create Highlight dependency

Download the latest version

```bash
$ git clone https://github.com/highlightjs/highlight.js.git
$ cd <highlightjs>
$ git checkout <version>
$ npm install
added 454 packages from 846 contributors and audited 2589 packages in 38.488s
found 2 vulnerabilities (1 low, 1 high)
  run `npm audit fix` to fix them, or `npm audit` for details
$ node tools/build.js -t cdn
```

package the build result `build/cdn`
