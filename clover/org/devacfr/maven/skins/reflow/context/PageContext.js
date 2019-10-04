var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":53,"id":972,"methods":[{"el":44,"sc":5,"sl":40},{"el":51,"sc":5,"sl":49}],"name":"PageContext","sl":29}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_21":{"methods":[{"sl":40},{"sl":49}],"name":"shouldBuildPageContextWithTocDisabled","pass":true,"statements":[{"sl":41},{"sl":42},{"sl":43},{"sl":50}]},"test_5":{"methods":[{"sl":40},{"sl":49}],"name":"shouldBuildPageContext","pass":true,"statements":[{"sl":41},{"sl":42},{"sl":43},{"sl":50}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [21, 5], [21, 5], [21, 5], [21, 5], [], [], [], [], [], [21, 5], [21, 5], [], [], []]