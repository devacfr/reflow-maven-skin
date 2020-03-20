var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":286,"id":897,"methods":[{"el":141,"sc":5,"sl":92},{"el":162,"sc":5,"sl":151},{"el":175,"sc":5,"sl":170},{"el":187,"sc":5,"sl":185},{"el":224,"sc":5,"sl":189},{"el":229,"sc":5,"sl":226},{"el":236,"sc":5,"sl":234},{"el":243,"sc":5,"sl":241},{"el":250,"sc":5,"sl":248},{"el":262,"sc":5,"sl":259},{"el":269,"sc":5,"sl":267},{"el":277,"sc":5,"sl":274},{"el":285,"sc":5,"sl":282}],"name":"Context","sl":53}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_11":{"methods":[{"sl":92},{"sl":151},{"sl":170},{"sl":259},{"sl":274}],"name":"shouldBuildDocumentContext","pass":true,"statements":[{"sl":94},{"sl":96},{"sl":97},{"sl":98},{"sl":101},{"sl":102},{"sl":104},{"sl":105},{"sl":106},{"sl":110},{"sl":117},{"sl":118},{"sl":119},{"sl":120},{"sl":121},{"sl":140},{"sl":152},{"sl":153},{"sl":154},{"sl":155},{"sl":156},{"sl":158},{"sl":161},{"sl":172},{"sl":173},{"sl":260},{"sl":261},{"sl":276}]},"test_12":{"methods":[{"sl":92},{"sl":151},{"sl":170},{"sl":185},{"sl":189},{"sl":259},{"sl":274}],"name":"shouldApplyBootstrapCss","pass":true,"statements":[{"sl":94},{"sl":96},{"sl":97},{"sl":98},{"sl":101},{"sl":102},{"sl":104},{"sl":117},{"sl":118},{"sl":135},{"sl":137},{"sl":138},{"sl":140},{"sl":152},{"sl":153},{"sl":154},{"sl":155},{"sl":156},{"sl":158},{"sl":161},{"sl":172},{"sl":173},{"sl":186},{"sl":191},{"sl":192},{"sl":193},{"sl":195},{"sl":201},{"sl":203},{"sl":205},{"sl":208},{"sl":211},{"sl":212},{"sl":215},{"sl":218},{"sl":222},{"sl":223},{"sl":260},{"sl":261},{"sl":276}]},"test_15":{"methods":[{"sl":92},{"sl":151},{"sl":170},{"sl":234},{"sl":241},{"sl":248},{"sl":259},{"sl":274}],"name":"shouldBuildFrameContext","pass":true,"statements":[{"sl":94},{"sl":96},{"sl":97},{"sl":98},{"sl":101},{"sl":102},{"sl":104},{"sl":105},{"sl":110},{"sl":111},{"sl":117},{"sl":118},{"sl":123},{"sl":125},{"sl":128},{"sl":129},{"sl":130},{"sl":131},{"sl":140},{"sl":152},{"sl":153},{"sl":154},{"sl":155},{"sl":156},{"sl":158},{"sl":161},{"sl":172},{"sl":173},{"sl":235},{"sl":242},{"sl":249},{"sl":260},{"sl":261},{"sl":276}]},"test_17":{"methods":[{"sl":92},{"sl":151},{"sl":170},{"sl":259},{"sl":274}],"name":"shouldBuildPageContextWithTocDisabled","pass":true,"statements":[{"sl":94},{"sl":96},{"sl":97},{"sl":98},{"sl":101},{"sl":102},{"sl":104},{"sl":117},{"sl":118},{"sl":135},{"sl":137},{"sl":138},{"sl":140},{"sl":152},{"sl":153},{"sl":154},{"sl":155},{"sl":156},{"sl":158},{"sl":161},{"sl":172},{"sl":173},{"sl":260},{"sl":261},{"sl":276}]},"test_3":{"methods":[{"sl":92},{"sl":151},{"sl":170},{"sl":234},{"sl":241},{"sl":248},{"sl":259},{"sl":267},{"sl":274}],"name":"shouldBuildPageContext","pass":true,"statements":[{"sl":94},{"sl":96},{"sl":97},{"sl":98},{"sl":101},{"sl":102},{"sl":104},{"sl":117},{"sl":118},{"sl":135},{"sl":137},{"sl":138},{"sl":140},{"sl":152},{"sl":153},{"sl":154},{"sl":155},{"sl":156},{"sl":158},{"sl":161},{"sl":172},{"sl":173},{"sl":235},{"sl":242},{"sl":249},{"sl":260},{"sl":261},{"sl":268},{"sl":276}]},"test_33":{"methods":[{"sl":92},{"sl":151},{"sl":185},{"sl":259},{"sl":274}],"name":"shouldRenderBodyWihoutModify","pass":true,"statements":[{"sl":94},{"sl":96},{"sl":97},{"sl":98},{"sl":101},{"sl":102},{"sl":104},{"sl":105},{"sl":106},{"sl":110},{"sl":117},{"sl":118},{"sl":132},{"sl":133},{"sl":134},{"sl":140},{"sl":152},{"sl":153},{"sl":154},{"sl":155},{"sl":156},{"sl":158},{"sl":161},{"sl":186},{"sl":260},{"sl":261},{"sl":276}]},"test_51":{"methods":[{"sl":92},{"sl":151},{"sl":170},{"sl":185},{"sl":189},{"sl":259},{"sl":274}],"name":"shouldReplaceTTTag","pass":true,"statements":[{"sl":94},{"sl":96},{"sl":97},{"sl":98},{"sl":101},{"sl":102},{"sl":104},{"sl":117},{"sl":118},{"sl":135},{"sl":137},{"sl":138},{"sl":140},{"sl":152},{"sl":153},{"sl":154},{"sl":155},{"sl":156},{"sl":158},{"sl":161},{"sl":172},{"sl":173},{"sl":186},{"sl":191},{"sl":192},{"sl":193},{"sl":195},{"sl":201},{"sl":203},{"sl":205},{"sl":208},{"sl":211},{"sl":212},{"sl":215},{"sl":218},{"sl":222},{"sl":223},{"sl":260},{"sl":261},{"sl":276}]},"test_53":{"methods":[{"sl":92},{"sl":151},{"sl":234},{"sl":241},{"sl":248},{"sl":259},{"sl":267},{"sl":274}],"name":"shouldBuildBodyContext","pass":true,"statements":[{"sl":94},{"sl":96},{"sl":97},{"sl":98},{"sl":101},{"sl":102},{"sl":104},{"sl":105},{"sl":106},{"sl":110},{"sl":117},{"sl":118},{"sl":132},{"sl":133},{"sl":134},{"sl":140},{"sl":152},{"sl":153},{"sl":154},{"sl":155},{"sl":156},{"sl":158},{"sl":161},{"sl":235},{"sl":242},{"sl":249},{"sl":260},{"sl":261},{"sl":268},{"sl":276}]},"test_60":{"methods":[{"sl":92},{"sl":151},{"sl":170},{"sl":185},{"sl":189},{"sl":259},{"sl":274}],"name":"shouldReplaceIcons","pass":true,"statements":[{"sl":94},{"sl":96},{"sl":97},{"sl":98},{"sl":101},{"sl":102},{"sl":104},{"sl":117},{"sl":118},{"sl":135},{"sl":137},{"sl":138},{"sl":140},{"sl":152},{"sl":153},{"sl":154},{"sl":155},{"sl":156},{"sl":158},{"sl":161},{"sl":172},{"sl":173},{"sl":186},{"sl":191},{"sl":192},{"sl":193},{"sl":195},{"sl":201},{"sl":203},{"sl":205},{"sl":208},{"sl":211},{"sl":212},{"sl":215},{"sl":218},{"sl":222},{"sl":223},{"sl":260},{"sl":261},{"sl":276}]},"test_64":{"methods":[{"sl":92},{"sl":151},{"sl":170},{"sl":185},{"sl":189},{"sl":259},{"sl":274}],"name":"shouldAddLighboxAttribute","pass":true,"statements":[{"sl":94},{"sl":96},{"sl":97},{"sl":98},{"sl":101},{"sl":102},{"sl":104},{"sl":117},{"sl":118},{"sl":135},{"sl":137},{"sl":138},{"sl":140},{"sl":152},{"sl":153},{"sl":154},{"sl":155},{"sl":156},{"sl":158},{"sl":161},{"sl":172},{"sl":173},{"sl":186},{"sl":191},{"sl":192},{"sl":193},{"sl":195},{"sl":201},{"sl":203},{"sl":205},{"sl":208},{"sl":211},{"sl":212},{"sl":215},{"sl":218},{"sl":222},{"sl":223},{"sl":260},{"sl":261},{"sl":276}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [51, 11, 33, 17, 53, 64, 15, 12, 3, 60], [], [51, 11, 33, 17, 53, 64, 15, 12, 3, 60], [], [51, 11, 33, 17, 53, 64, 15, 12, 3, 60], [51, 11, 33, 17, 53, 64, 15, 12, 3, 60], [51, 11, 33, 17, 53, 64, 15, 12, 3, 60], [], [], [51, 11, 33, 17, 53, 64, 15, 12, 3, 60], [51, 11, 33, 17, 53, 64, 15, 12, 3, 60], [], [51, 11, 33, 17, 53, 64, 15, 12, 3, 60], [11, 33, 53, 15], [11, 33, 53], [], [], [], [11, 33, 53, 15], [15], [], [], [], [], [], [51, 11, 33, 17, 53, 64, 15, 12, 3, 60], [51, 11, 33, 17, 53, 64, 15, 12, 3, 60], [11], [11], [11], [], [15], [], [15], [], [], [15], [15], [15], [15], [33, 53], [33, 53], [33, 53], [51, 17, 64, 12, 3, 60], [], [51, 17, 64, 12, 3, 60], [51, 17, 64, 12, 3, 60], [], [51, 11, 33, 17, 53, 64, 15, 12, 3, 60], [], [], [], [], [], [], [], [], [], [], [51, 11, 33, 17, 53, 64, 15, 12, 3, 60], [51, 11, 33, 17, 53, 64, 15, 12, 3, 60], [51, 11, 33, 17, 53, 64, 15, 12, 3, 60], [51, 11, 33, 17, 53, 64, 15, 12, 3, 60], [51, 11, 33, 17, 53, 64, 15, 12, 3, 60], [51, 11, 33, 17, 53, 64, 15, 12, 3, 60], [], [51, 11, 33, 17, 53, 64, 15, 12, 3, 60], [], [], [51, 11, 33, 17, 53, 64, 15, 12, 3, 60], [], [], [], [], [], [], [], [], [51, 11, 17, 64, 15, 12, 3, 60], [], [51, 11, 17, 64, 15, 12, 3, 60], [51, 11, 17, 64, 15, 12, 3, 60], [], [], [], [], [], [], [], [], [], [], [], [51, 33, 64, 12, 60], [51, 33, 64, 12, 60], [], [], [51, 64, 12, 60], [], [51, 64, 12, 60], [51, 64, 12, 60], [51, 64, 12, 60], [], [51, 64, 12, 60], [], [], [], [], [], [51, 64, 12, 60], [], [51, 64, 12, 60], [], [51, 64, 12, 60], [], [], [51, 64, 12, 60], [], [], [51, 64, 12, 60], [51, 64, 12, 60], [], [], [51, 64, 12, 60], [], [], [51, 64, 12, 60], [], [], [], [51, 64, 12, 60], [51, 64, 12, 60], [], [], [], [], [], [], [], [], [], [], [53, 15, 3], [53, 15, 3], [], [], [], [], [], [53, 15, 3], [53, 15, 3], [], [], [], [], [], [53, 15, 3], [53, 15, 3], [], [], [], [], [], [], [], [], [], [51, 11, 33, 17, 53, 64, 15, 12, 3, 60], [51, 11, 33, 17, 53, 64, 15, 12, 3, 60], [51, 11, 33, 17, 53, 64, 15, 12, 3, 60], [], [], [], [], [], [53, 3], [53, 3], [], [], [], [], [], [51, 11, 33, 17, 53, 64, 15, 12, 3, 60], [], [51, 11, 33, 17, 53, 64, 15, 12, 3, 60], [], [], [], [], [], [], [], [], [], []]