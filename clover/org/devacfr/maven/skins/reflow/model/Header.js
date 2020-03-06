var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":104,"id":1110,"methods":[{"el":78,"sc":5,"sl":58},{"el":87,"sc":5,"sl":85},{"el":95,"sc":5,"sl":93},{"el":102,"sc":5,"sl":100}],"name":"Header","sl":36}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_11":{"methods":[{"sl":58}],"name":"shouldBuildPageContext","pass":true,"statements":[{"sl":59},{"sl":60},{"sl":61},{"sl":62},{"sl":63},{"sl":65},{"sl":66},{"sl":69},{"sl":71},{"sl":72}]},"test_21":{"methods":[{"sl":58}],"name":"shouldBuildPageContextWithTocDisabled","pass":true,"statements":[{"sl":59},{"sl":60},{"sl":61},{"sl":62},{"sl":63},{"sl":65},{"sl":66},{"sl":69},{"sl":71},{"sl":72}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [11, 21], [11, 21], [11, 21], [11, 21], [11, 21], [11, 21], [], [11, 21], [11, 21], [], [], [11, 21], [], [11, 21], [11, 21], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], []]