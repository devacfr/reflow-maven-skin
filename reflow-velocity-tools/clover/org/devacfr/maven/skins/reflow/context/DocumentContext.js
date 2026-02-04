var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":52,"id":1303,"methods":[{"el":44,"sc":3,"sl":39},{"el":51,"sc":3,"sl":49}],"name":"DocumentContext","sl":28}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_173":{"methods":[{"sl":39},{"sl":49}],"name":"shouldBuildDocumentContext","pass":true,"statements":[{"sl":40},{"sl":41},{"sl":43},{"sl":50}]},"test_99":{"methods":[{"sl":39},{"sl":49}],"name":"shouldBuildDocumentContext","pass":true,"statements":[{"sl":40},{"sl":41},{"sl":43},{"sl":50}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [99, 173], [99, 173], [99, 173], [], [99, 173], [], [], [], [], [], [99, 173], [99, 173], [], []]