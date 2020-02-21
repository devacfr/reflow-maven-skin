var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":67,"id":1004,"methods":[{"el":49,"sc":5,"sl":44},{"el":58,"sc":5,"sl":56},{"el":65,"sc":5,"sl":63}],"name":"PageContext","sl":30}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_11":{"methods":[{"sl":44},{"sl":63}],"name":"shouldBuildPageContext","pass":true,"statements":[{"sl":45},{"sl":46},{"sl":47},{"sl":48},{"sl":64}]},"test_40":{"methods":[{"sl":44},{"sl":63}],"name":"shouldBuildPageContextWithTocDisabled","pass":true,"statements":[{"sl":45},{"sl":46},{"sl":47},{"sl":48},{"sl":64}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [11, 40], [11, 40], [11, 40], [11, 40], [11, 40], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [11, 40], [11, 40], [], [], []]