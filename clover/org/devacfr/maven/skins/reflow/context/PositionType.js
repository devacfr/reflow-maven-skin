var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":38,"id":2217,"methods":[{"el":32,"sc":3,"sl":29},{"el":37,"sc":3,"sl":34}],"name":"PositionType","sl":20}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_15":{"methods":[{"sl":29}],"name":"shouldDisplayDatePositionToRight","pass":true,"statements":[{"sl":31}]},"test_19":{"methods":[{"sl":29}],"name":"shouldDisplayVersionPositionToLeft","pass":true,"statements":[{"sl":31}]},"test_21":{"methods":[{"sl":29}],"name":"shouldNotDisplayDateForUnrecognizedPosition","pass":true,"statements":[{"sl":31}]},"test_67":{"methods":[{"sl":29}],"name":"shouldDisplayDatePositionToLeft","pass":true,"statements":[{"sl":31}]},"test_89":{"methods":[{"sl":29}],"name":"shouldDisplayVersionPositionToRight","pass":true,"statements":[{"sl":31}]},"test_97":{"methods":[{"sl":29}],"name":"shouldNotDisplayDate","pass":true,"statements":[{"sl":31}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [67, 97, 89, 19, 21, 15], [], [67, 97, 89, 19, 21, 15], [], [], [], [], [], [], []]