var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":38,"id":2217,"methods":[{"el":32,"sc":3,"sl":29},{"el":37,"sc":3,"sl":34}],"name":"PositionType","sl":20}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_31":{"methods":[{"sl":29}],"name":"shouldDisplayVersionPositionToRight","pass":true,"statements":[{"sl":31}]},"test_35":{"methods":[{"sl":29}],"name":"shouldDisplayVersionPositionToLeft","pass":true,"statements":[{"sl":31}]},"test_4":{"methods":[{"sl":29}],"name":"shouldNotDisplayDateForUnrecognizedPosition","pass":true,"statements":[{"sl":31}]},"test_45":{"methods":[{"sl":29}],"name":"shouldDisplayDatePositionToRight","pass":true,"statements":[{"sl":31}]},"test_73":{"methods":[{"sl":29}],"name":"shouldNotDisplayDate","pass":true,"statements":[{"sl":31}]},"test_93":{"methods":[{"sl":29}],"name":"shouldDisplayDatePositionToLeft","pass":true,"statements":[{"sl":31}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [93, 73, 4, 31, 45, 35], [], [93, 73, 4, 31, 45, 35], [], [], [], [], [], [], []]