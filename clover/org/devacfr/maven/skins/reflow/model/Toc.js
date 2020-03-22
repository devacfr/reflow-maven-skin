var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":196,"id":1508,"methods":[{"el":94,"sc":5,"sl":65},{"el":103,"sc":5,"sl":101},{"el":112,"sc":5,"sl":110},{"el":123,"sc":5,"sl":120},{"el":131,"sc":5,"sl":128},{"el":138,"sc":5,"sl":136},{"el":147,"sc":5,"sl":145},{"el":162,"sc":5,"sl":155},{"el":174,"sc":5,"sl":171},{"el":187,"sc":5,"sl":176},{"el":195,"sc":5,"sl":192}],"name":"Toc","sl":42}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_1":{"methods":[{"sl":120},{"sl":128},{"sl":145},{"sl":171}],"name":"shouldBuildFrameContext","pass":true,"statements":[{"sl":121},{"sl":122},{"sl":130},{"sl":146},{"sl":172},{"sl":173}]},"test_15":{"methods":[{"sl":65},{"sl":120},{"sl":128},{"sl":171},{"sl":176}],"name":"shouldAddLighboxAttribute","pass":true,"statements":[{"sl":66},{"sl":67},{"sl":68},{"sl":71},{"sl":72},{"sl":74},{"sl":75},{"sl":77},{"sl":84},{"sl":86},{"sl":89},{"sl":90},{"sl":93},{"sl":121},{"sl":122},{"sl":130},{"sl":172},{"sl":173},{"sl":178},{"sl":185}]},"test_17":{"methods":[{"sl":65},{"sl":120},{"sl":128},{"sl":171},{"sl":176}],"name":"shouldApplyBootstrapCss","pass":true,"statements":[{"sl":66},{"sl":67},{"sl":68},{"sl":71},{"sl":72},{"sl":74},{"sl":75},{"sl":77},{"sl":84},{"sl":86},{"sl":89},{"sl":90},{"sl":93},{"sl":121},{"sl":122},{"sl":130},{"sl":172},{"sl":173},{"sl":178},{"sl":185}]},"test_39":{"methods":[{"sl":65},{"sl":120},{"sl":128},{"sl":145},{"sl":171}],"name":"shouldBuildPageContextWithTocDisabled","pass":true,"statements":[{"sl":66},{"sl":67},{"sl":68},{"sl":71},{"sl":72},{"sl":74},{"sl":75},{"sl":77},{"sl":84},{"sl":86},{"sl":89},{"sl":90},{"sl":93},{"sl":121},{"sl":122},{"sl":130},{"sl":146},{"sl":172},{"sl":173}]},"test_40":{"methods":[{"sl":65},{"sl":120},{"sl":128},{"sl":171},{"sl":176}],"name":"shouldReplaceTTTag","pass":true,"statements":[{"sl":66},{"sl":67},{"sl":68},{"sl":71},{"sl":72},{"sl":74},{"sl":75},{"sl":77},{"sl":84},{"sl":86},{"sl":89},{"sl":90},{"sl":93},{"sl":121},{"sl":122},{"sl":130},{"sl":172},{"sl":173},{"sl":178},{"sl":185}]},"test_69":{"methods":[{"sl":65},{"sl":110},{"sl":120},{"sl":128},{"sl":145},{"sl":171}],"name":"shouldBuildPageContext","pass":true,"statements":[{"sl":66},{"sl":67},{"sl":68},{"sl":71},{"sl":74},{"sl":77},{"sl":81},{"sl":82},{"sl":83},{"sl":93},{"sl":111},{"sl":121},{"sl":122},{"sl":130},{"sl":146},{"sl":172},{"sl":173}]},"test_70":{"methods":[{"sl":65},{"sl":120},{"sl":128},{"sl":171},{"sl":176}],"name":"shouldReplaceIcons","pass":true,"statements":[{"sl":66},{"sl":67},{"sl":68},{"sl":71},{"sl":72},{"sl":74},{"sl":75},{"sl":77},{"sl":84},{"sl":86},{"sl":89},{"sl":90},{"sl":93},{"sl":121},{"sl":122},{"sl":130},{"sl":172},{"sl":173},{"sl":178},{"sl":185}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [40, 69, 39, 15, 17, 70], [40, 69, 39, 15, 17, 70], [40, 69, 39, 15, 17, 70], [40, 69, 39, 15, 17, 70], [], [], [40, 69, 39, 15, 17, 70], [40, 39, 15, 17, 70], [], [40, 69, 39, 15, 17, 70], [40, 39, 15, 17, 70], [], [40, 69, 39, 15, 17, 70], [], [], [], [69], [69], [69], [40, 39, 15, 17, 70], [], [40, 39, 15, 17, 70], [], [], [40, 39, 15, 17, 70], [40, 39, 15, 17, 70], [], [], [40, 69, 39, 15, 17, 70], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [69], [69], [], [], [], [], [], [], [], [], [40, 69, 39, 15, 1, 17, 70], [40, 69, 39, 15, 1, 17, 70], [40, 69, 39, 15, 1, 17, 70], [], [], [], [], [], [40, 69, 39, 15, 1, 17, 70], [], [40, 69, 39, 15, 1, 17, 70], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [69, 39, 1], [69, 39, 1], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [40, 69, 39, 15, 1, 17, 70], [40, 69, 39, 15, 1, 17, 70], [40, 69, 39, 15, 1, 17, 70], [], [], [40, 15, 17, 70], [], [40, 15, 17, 70], [], [], [], [], [], [], [40, 15, 17, 70], [], [], [], [], [], [], [], [], [], [], []]