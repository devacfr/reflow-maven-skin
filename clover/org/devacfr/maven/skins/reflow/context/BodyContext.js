var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":48,"id":902,"methods":[{"el":36,"sc":5,"sl":34},{"el":41,"sc":5,"sl":38},{"el":46,"sc":5,"sl":43}],"name":"BodyContext","sl":26}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_31":{"methods":[{"sl":34},{"sl":38},{"sl":43}],"name":"shouldRenderBodyWihoutModify","pass":true,"statements":[{"sl":35},{"sl":45}]},"test_41":{"methods":[{"sl":34},{"sl":38}],"name":"shouldBuildBodyContext","pass":true,"statements":[{"sl":35}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [31, 41], [31, 41], [], [], [31, 41], [], [], [], [], [31], [], [31], [], [], []]