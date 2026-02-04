var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":46,"id":1205,"methods":[{"el":35,"sc":3,"sl":33},{"el":40,"sc":3,"sl":37},{"el":45,"sc":3,"sl":42}],"name":"BodyContext","sl":25}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_153":{"methods":[{"sl":33},{"sl":37}],"name":"shouldBuildBodyContext","pass":true,"statements":[{"sl":34}]},"test_178":{"methods":[{"sl":33},{"sl":37},{"sl":42}],"name":"shouldRenderBodyWihoutModify","pass":true,"statements":[{"sl":34},{"sl":44}]},"test_192":{"methods":[{"sl":33},{"sl":37},{"sl":42}],"name":"shouldRenderBodyWihoutModify","pass":true,"statements":[{"sl":34},{"sl":44}]},"test_91":{"methods":[{"sl":33},{"sl":37}],"name":"shouldBuildBodyContext","pass":true,"statements":[{"sl":34}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [178, 91, 153, 192], [178, 91, 153, 192], [], [], [178, 91, 153, 192], [], [], [], [], [178, 192], [], [178, 192], [], []]