var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":54,"id":1318,"methods":[{"el":32,"sc":3,"sl":24},{"el":42,"sc":3,"sl":34},{"el":52,"sc":3,"sl":44}],"name":"JsoupUtilTest","sl":22}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_21":{"methods":[{"sl":44}],"name":"shouldHasTextNode","pass":true,"statements":[{"sl":46},{"sl":51}]},"test_28":{"methods":[{"sl":34}],"name":"shouldNotModifyVerbatimCode","pass":true,"statements":[{"sl":36},{"sl":37},{"sl":38},{"sl":39}]},"test_52":{"methods":[{"sl":24}],"name":"shouldAcceptSvgAndUnrecognizedElement","pass":true,"statements":[{"sl":26},{"sl":27},{"sl":28},{"sl":29}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [52], [], [52], [52], [52], [52], [], [], [], [], [28], [], [28], [28], [28], [28], [], [], [], [], [21], [], [21], [], [], [], [], [21], [], [], []]