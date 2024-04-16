var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":50,"id":918,"methods":[{"el":39,"sc":5,"sl":37},{"el":44,"sc":5,"sl":41},{"el":49,"sc":5,"sl":46}],"name":"BodyContext","sl":29}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_53":{"methods":[{"sl":37},{"sl":41}],"name":"shouldBuildBodyContext","pass":true,"statements":[{"sl":38}]},"test_78":{"methods":[{"sl":37},{"sl":41},{"sl":46}],"name":"shouldRenderBodyWihoutModify","pass":true,"statements":[{"sl":38},{"sl":48}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [53, 78], [53, 78], [], [], [53, 78], [], [], [], [], [78], [], [78], [], []]