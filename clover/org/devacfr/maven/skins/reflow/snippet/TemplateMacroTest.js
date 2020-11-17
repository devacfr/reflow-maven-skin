var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":60,"id":2783,"methods":[{"el":32,"sc":5,"sl":28},{"el":46,"sc":5,"sl":34},{"el":58,"sc":5,"sl":48}],"name":"TemplateMacroTest","sl":26}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_32":{"methods":[{"sl":48}],"name":"shouldConvertHtmlSnippet","pass":true,"statements":[{"sl":50},{"sl":51},{"sl":52},{"sl":53}]},"test_53":{"methods":[{"sl":34}],"name":"shouldConvert","pass":true,"statements":[{"sl":36},{"sl":38},{"sl":39},{"sl":40}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [53], [], [53], [], [53], [53], [53], [], [], [], [], [], [], [], [32], [], [32], [32], [32], [32], [], [], [], [], [], [], []]