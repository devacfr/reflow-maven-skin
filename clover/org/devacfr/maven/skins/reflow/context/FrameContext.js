var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":76,"id":999,"methods":[{"el":53,"sc":5,"sl":46},{"el":60,"sc":5,"sl":58},{"el":67,"sc":5,"sl":65},{"el":74,"sc":5,"sl":72}],"name":"FrameContext","sl":32}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_9":{"methods":[{"sl":46},{"sl":58},{"sl":72}],"name":"shouldBuildFrameContext","pass":true,"statements":[{"sl":47},{"sl":48},{"sl":49},{"sl":50},{"sl":52},{"sl":59},{"sl":73}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [9], [9], [9], [9], [9], [], [9], [], [], [], [], [], [9], [9], [], [], [], [], [], [], [], [], [], [], [], [], [9], [9], [], [], []]