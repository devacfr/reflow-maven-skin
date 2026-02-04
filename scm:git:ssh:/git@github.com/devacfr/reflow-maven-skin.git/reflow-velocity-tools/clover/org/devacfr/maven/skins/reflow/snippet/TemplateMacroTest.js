var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":49,"id":3555,"methods":[{"el":36,"sc":3,"sl":25},{"el":48,"sc":3,"sl":38}],"name":"TemplateMacroTest","sl":23}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_120":{"methods":[{"sl":25}],"name":"shouldConvert","pass":true,"statements":[{"sl":27},{"sl":29},{"sl":30},{"sl":31}]},"test_148":{"methods":[{"sl":25}],"name":"shouldConvert","pass":true,"statements":[{"sl":27},{"sl":29},{"sl":30},{"sl":31}]},"test_24":{"methods":[{"sl":38}],"name":"shouldConvertHtmlSnippet","pass":true,"statements":[{"sl":40},{"sl":41},{"sl":42},{"sl":43}]},"test_96":{"methods":[{"sl":38}],"name":"shouldConvertHtmlSnippet","pass":true,"statements":[{"sl":40},{"sl":41},{"sl":42},{"sl":43}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [120, 148], [], [120, 148], [], [120, 148], [120, 148], [120, 148], [], [], [], [], [], [], [24, 96], [], [24, 96], [24, 96], [24, 96], [24, 96], [], [], [], [], [], []]