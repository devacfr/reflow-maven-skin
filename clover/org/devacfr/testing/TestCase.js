var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":140,"id":2110,"methods":[{"el":41,"sc":5,"sl":38},{"el":45,"sc":5,"sl":43},{"el":55,"sc":5,"sl":52},{"el":59,"sc":5,"sl":57},{"el":71,"sc":5,"sl":68},{"el":75,"sc":5,"sl":73},{"el":79,"sc":5,"sl":77},{"el":83,"sc":5,"sl":81},{"el":87,"sc":5,"sl":85},{"el":91,"sc":5,"sl":89},{"el":95,"sc":5,"sl":93},{"el":102,"sc":5,"sl":100},{"el":106,"sc":5,"sl":104},{"el":113,"sc":5,"sl":111},{"el":122,"sc":5,"sl":120},{"el":131,"sc":5,"sl":129},{"el":138,"sc":5,"sl":133}],"name":"TestCase","sl":34}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_10":{"methods":[{"sl":52},{"sl":68},{"sl":81},{"sl":133}],"name":"shouldHeadingTree","pass":true,"statements":[{"sl":54},{"sl":70},{"sl":82},{"sl":134},{"sl":137}]},"test_12":{"methods":[{"sl":52},{"sl":68},{"sl":81},{"sl":85},{"sl":133}],"name":"shouldExtract","pass":true,"statements":[{"sl":54},{"sl":70},{"sl":82},{"sl":86},{"sl":134},{"sl":137}]},"test_18":{"methods":[{"sl":52},{"sl":68},{"sl":111},{"sl":133}],"name":"shouldHeadingAnchorToId","pass":true,"statements":[{"sl":54},{"sl":70},{"sl":112},{"sl":134},{"sl":137}]},"test_2":{"methods":[{"sl":52},{"sl":68},{"sl":73},{"sl":133}],"name":"shouldSplitBodyFragment","pass":true,"statements":[{"sl":54},{"sl":70},{"sl":74},{"sl":134},{"sl":137}]},"test_21":{"methods":[{"sl":52},{"sl":68},{"sl":111},{"sl":133}],"name":"shouldReorderToTopOneSection","pass":true,"statements":[{"sl":54},{"sl":70},{"sl":112},{"sl":134},{"sl":137}]},"test_22":{"methods":[{"sl":52},{"sl":68},{"sl":111},{"sl":133}],"name":"shouldEnsureHeadingIdsForFrame","pass":true,"statements":[{"sl":54},{"sl":70},{"sl":112},{"sl":134},{"sl":137}]},"test_26":{"methods":[{"sl":52},{"sl":68},{"sl":104},{"sl":133}],"name":"fixTableHeadsWithTagListReportOuput","pass":true,"statements":[{"sl":54},{"sl":70},{"sl":105},{"sl":134},{"sl":137}]},"test_28":{"methods":[{"sl":52},{"sl":68},{"sl":73},{"sl":133}],"name":"shouldSplitRecursively","pass":true,"statements":[{"sl":54},{"sl":70},{"sl":74},{"sl":134},{"sl":137}]},"test_3":{"methods":[{"sl":52},{"sl":68},{"sl":73},{"sl":133}],"name":"shouldSplitJoinSeparatorNo","pass":true,"statements":[{"sl":54},{"sl":70},{"sl":74},{"sl":134},{"sl":137}]},"test_30":{"methods":[{"sl":52},{"sl":68},{"sl":73},{"sl":133}],"name":"shouldSplitJoinSeparatorBefore","pass":true,"statements":[{"sl":54},{"sl":70},{"sl":74},{"sl":134},{"sl":137}]},"test_37":{"methods":[{"sl":52},{"sl":68},{"sl":73},{"sl":133}],"name":"shouldNotSplit","pass":true,"statements":[{"sl":54},{"sl":70},{"sl":74},{"sl":134},{"sl":137}]},"test_42":{"methods":[{"sl":52},{"sl":68},{"sl":111},{"sl":133}],"name":"shouldEnsureHeadingIds","pass":true,"statements":[{"sl":54},{"sl":70},{"sl":112},{"sl":134},{"sl":137}]},"test_44":{"methods":[{"sl":52},{"sl":68},{"sl":73},{"sl":133}],"name":"shouldSplitOnStarts","pass":true,"statements":[{"sl":54},{"sl":70},{"sl":74},{"sl":134},{"sl":137}]},"test_7":{"methods":[{"sl":52},{"sl":68},{"sl":73},{"sl":133}],"name":"shouldSplitJoinSeparatorAfter","pass":true,"statements":[{"sl":54},{"sl":70},{"sl":74},{"sl":134},{"sl":137}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [21, 10, 42, 12, 3, 22, 28, 37, 44, 2, 18, 26, 30, 7], [], [21, 10, 42, 12, 3, 22, 28, 37, 44, 2, 18, 26, 30, 7], [], [], [], [], [], [], [], [], [], [], [], [], [], [21, 10, 42, 12, 3, 22, 28, 37, 44, 2, 18, 26, 30, 7], [], [21, 10, 42, 12, 3, 22, 28, 37, 44, 2, 18, 26, 30, 7], [], [], [3, 28, 37, 44, 2, 30, 7], [3, 28, 37, 44, 2, 30, 7], [], [], [], [], [], [], [10, 12], [10, 12], [], [], [12], [12], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [26], [26], [], [], [], [], [], [21, 42, 22, 18], [21, 42, 22, 18], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [21, 10, 42, 12, 3, 22, 28, 37, 44, 2, 18, 26, 30, 7], [21, 10, 42, 12, 3, 22, 28, 37, 44, 2, 18, 26, 30, 7], [], [], [21, 10, 42, 12, 3, 22, 28, 37, 44, 2, 18, 26, 30, 7], [], [], []]