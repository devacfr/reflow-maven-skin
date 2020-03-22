var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":190,"id":820,"methods":[{"el":70,"sc":5,"sl":56},{"el":82,"sc":5,"sl":79},{"el":99,"sc":5,"sl":96},{"el":118,"sc":5,"sl":108}],"name":"URITool","sl":37},{"el":189,"id":843,"methods":[{"el":145,"sc":9,"sl":142},{"el":155,"sc":9,"sl":152},{"el":165,"sc":9,"sl":162},{"el":188,"sc":9,"sl":175}],"name":"URITool.URLRebaser","sl":124}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_10":{"methods":[{"sl":142},{"sl":152},{"sl":162},{"sl":175}],"name":"rebaseUrlOnChildProject","pass":true,"statements":[{"sl":143},{"sl":144},{"sl":154},{"sl":164},{"sl":176},{"sl":180},{"sl":185},{"sl":187}]},"test_23":{"methods":[{"sl":56}],"name":"shouldRelativizeLinkAccetupNullBase","pass":true,"statements":[{"sl":61},{"sl":62}]},"test_36":{"methods":[{"sl":56},{"sl":79},{"sl":108}],"name":"relativeSubModuleLink","pass":true,"statements":[{"sl":61},{"sl":64},{"sl":65},{"sl":66},{"sl":81},{"sl":110},{"sl":113},{"sl":117}]},"test_37":{"methods":[{"sl":56}],"name":"shouldRelativizeLinkAcceptsAbsoluteBaseUri","pass":true,"statements":[{"sl":61},{"sl":64},{"sl":65},{"sl":68}]},"test_48":{"methods":[{"sl":108}],"name":"shouldNormalisedBaseUrlAcceptNullParameter","pass":true,"statements":[{"sl":110},{"sl":111}]},"test_55":{"methods":[{"sl":96},{"sl":142},{"sl":152},{"sl":162},{"sl":175}],"name":"rebaseUrlOnRootProject","pass":true,"statements":[{"sl":98},{"sl":143},{"sl":144},{"sl":154},{"sl":164},{"sl":176},{"sl":180},{"sl":185},{"sl":187}]},"test_61":{"methods":[{"sl":56},{"sl":79},{"sl":108}],"name":"relativeRootLink","pass":true,"statements":[{"sl":61},{"sl":64},{"sl":65},{"sl":66},{"sl":81},{"sl":110},{"sl":113},{"sl":114}]},"test_64":{"methods":[{"sl":142},{"sl":162},{"sl":175}],"name":"rebaseUrlWithParentNullValue","pass":true,"statements":[{"sl":143},{"sl":144},{"sl":164},{"sl":176},{"sl":177}]},"test_67":{"methods":[{"sl":56},{"sl":79},{"sl":108}],"name":"relativeSubFolderLink","pass":true,"statements":[{"sl":61},{"sl":64},{"sl":65},{"sl":66},{"sl":81},{"sl":110},{"sl":113},{"sl":117}]},"test_70":{"methods":[{"sl":96},{"sl":142},{"sl":162},{"sl":175}],"name":"rebaseUrlNonInterpolate","pass":true,"statements":[{"sl":98},{"sl":143},{"sl":144},{"sl":164},{"sl":176},{"sl":180},{"sl":181}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [67, 37, 36, 23, 61], [], [], [], [], [67, 37, 36, 23, 61], [23], [], [67, 37, 36, 61], [67, 37, 36, 61], [67, 36, 61], [], [37], [], [], [], [], [], [], [], [], [], [], [67, 36, 61], [], [67, 36, 61], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [70, 55], [], [70, 55], [], [], [], [], [], [], [], [], [], [48, 67, 36, 61], [], [48, 67, 36, 61], [48], [], [67, 36, 61], [61], [], [], [67, 36], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [10, 70, 55, 64], [10, 70, 55, 64], [10, 70, 55, 64], [], [], [], [], [], [], [], [10, 55], [], [10, 55], [], [], [], [], [], [], [], [10, 70, 55, 64], [], [10, 70, 55, 64], [], [], [], [], [], [], [], [], [], [], [10, 70, 55, 64], [10, 70, 55, 64], [64], [], [], [10, 70, 55], [70], [], [], [], [10, 55], [], [10, 55], [], [], []]