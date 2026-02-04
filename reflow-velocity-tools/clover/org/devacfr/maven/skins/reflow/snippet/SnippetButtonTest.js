var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":44,"id":3489,"methods":[{"el":32,"sc":3,"sl":23},{"el":43,"sc":3,"sl":34}],"name":"SnippetButtonTest","sl":21}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_129":{"methods":[{"sl":23}],"name":"shouldDisplayButtonToolbar","pass":true,"statements":[{"sl":25},{"sl":26},{"sl":27}]},"test_133":{"methods":[{"sl":34}],"name":"shouldRenderGroupButton","pass":true,"statements":[{"sl":36},{"sl":37},{"sl":38}]},"test_149":{"methods":[{"sl":23}],"name":"shouldDisplayButtonToolbar","pass":true,"statements":[{"sl":25},{"sl":26},{"sl":27}]},"test_31":{"methods":[{"sl":34}],"name":"shouldRenderGroupButton","pass":true,"statements":[{"sl":36},{"sl":37},{"sl":38}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [129, 149], [], [129, 149], [129, 149], [129, 149], [], [], [], [], [], [], [31, 133], [], [31, 133], [31, 133], [31, 133], [], [], [], [], [], []]