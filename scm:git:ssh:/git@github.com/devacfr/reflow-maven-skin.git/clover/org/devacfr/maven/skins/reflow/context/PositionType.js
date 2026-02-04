var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":38,"id":2217,"methods":[{"el":32,"sc":3,"sl":29},{"el":37,"sc":3,"sl":34}],"name":"PositionType","sl":20}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_102":{"methods":[{"sl":29}],"name":"shouldNotDisplayDate","pass":true,"statements":[{"sl":31}]},"test_26":{"methods":[{"sl":29}],"name":"shouldDisplayVersionPositionToLeft","pass":true,"statements":[{"sl":31}]},"test_32":{"methods":[{"sl":29}],"name":"shouldDisplayDatePositionToLeft","pass":true,"statements":[{"sl":31}]},"test_46":{"methods":[{"sl":29}],"name":"shouldDisplayVersionPositionToRight","pass":true,"statements":[{"sl":31}]},"test_63":{"methods":[{"sl":29}],"name":"shouldNotDisplayDateForUnrecognizedPosition","pass":true,"statements":[{"sl":31}]},"test_85":{"methods":[{"sl":29}],"name":"shouldDisplayDatePositionToRight","pass":true,"statements":[{"sl":31}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [26, 46, 102, 85, 32, 63], [], [26, 46, 102, 85, 32, 63], [], [], [], [], [], [], []]