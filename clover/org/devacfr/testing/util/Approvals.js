var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":159,"id":2167,"methods":[{"el":44,"sc":5,"sl":42},{"el":65,"sc":5,"sl":58},{"el":91,"sc":5,"sl":79},{"el":112,"sc":5,"sl":105},{"el":125,"sc":5,"sl":114},{"el":149,"sc":5,"sl":141},{"el":157,"sc":5,"sl":151}],"name":"Approvals","sl":38}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_1":{"methods":[{"sl":58},{"sl":79},{"sl":114},{"sl":151}],"name":"shouldEnsureHeadingIdsForFrame","pass":true,"statements":[{"sl":62},{"sl":63},{"sl":64},{"sl":84},{"sl":85},{"sl":86},{"sl":87},{"sl":90},{"sl":119},{"sl":120},{"sl":121},{"sl":123},{"sl":124},{"sl":152},{"sl":153}]},"test_15":{"methods":[{"sl":58},{"sl":151}],"name":"shouldSplitJoinSeparatorNo","pass":true,"statements":[{"sl":62},{"sl":63},{"sl":64},{"sl":152},{"sl":153}]},"test_21":{"methods":[{"sl":58},{"sl":79},{"sl":151}],"name":"shouldExtract","pass":true,"statements":[{"sl":62},{"sl":63},{"sl":64},{"sl":84},{"sl":85},{"sl":86},{"sl":87},{"sl":90},{"sl":152},{"sl":153}]},"test_22":{"methods":[{"sl":58},{"sl":151}],"name":"shouldSplitJoinSeparatorAfter","pass":true,"statements":[{"sl":62},{"sl":63},{"sl":64},{"sl":152},{"sl":153}]},"test_26":{"methods":[{"sl":58},{"sl":79},{"sl":114},{"sl":151}],"name":"shouldEnsureHeadingIds","pass":true,"statements":[{"sl":62},{"sl":63},{"sl":64},{"sl":84},{"sl":85},{"sl":86},{"sl":87},{"sl":90},{"sl":119},{"sl":120},{"sl":121},{"sl":123},{"sl":124},{"sl":152},{"sl":153}]},"test_35":{"methods":[{"sl":58},{"sl":151}],"name":"shouldSplitJoinSeparatorBefore","pass":true,"statements":[{"sl":62},{"sl":63},{"sl":64},{"sl":152},{"sl":153}]},"test_36":{"methods":[{"sl":58},{"sl":79},{"sl":114},{"sl":151}],"name":"shouldHeadingAnchorToId","pass":true,"statements":[{"sl":62},{"sl":63},{"sl":64},{"sl":84},{"sl":85},{"sl":86},{"sl":87},{"sl":90},{"sl":119},{"sl":120},{"sl":121},{"sl":123},{"sl":124},{"sl":152},{"sl":153}]},"test_38":{"methods":[{"sl":58},{"sl":79},{"sl":114},{"sl":151}],"name":"fixTableHeadsWithTagListReportOuput","pass":true,"statements":[{"sl":62},{"sl":63},{"sl":64},{"sl":84},{"sl":85},{"sl":86},{"sl":87},{"sl":90},{"sl":119},{"sl":120},{"sl":121},{"sl":123},{"sl":124},{"sl":152},{"sl":153}]},"test_39":{"methods":[{"sl":58},{"sl":151}],"name":"shouldSplitRecursively","pass":true,"statements":[{"sl":62},{"sl":63},{"sl":64},{"sl":152},{"sl":153}]},"test_41":{"methods":[{"sl":58},{"sl":151}],"name":"shouldSplitOnStarts","pass":true,"statements":[{"sl":62},{"sl":63},{"sl":64},{"sl":152},{"sl":153}]},"test_45":{"methods":[{"sl":58},{"sl":79},{"sl":114},{"sl":151}],"name":"shouldReorderToTopOneSection","pass":true,"statements":[{"sl":62},{"sl":63},{"sl":64},{"sl":84},{"sl":85},{"sl":86},{"sl":87},{"sl":90},{"sl":119},{"sl":120},{"sl":121},{"sl":123},{"sl":124},{"sl":152},{"sl":153}]},"test_46":{"methods":[{"sl":58},{"sl":151}],"name":"shouldSplitBodyFragment","pass":true,"statements":[{"sl":62},{"sl":63},{"sl":64},{"sl":152},{"sl":153}]},"test_6":{"methods":[{"sl":58},{"sl":151}],"name":"shouldHeadingTree","pass":true,"statements":[{"sl":62},{"sl":63},{"sl":64},{"sl":152},{"sl":153}]},"test_7":{"methods":[{"sl":58},{"sl":151}],"name":"shouldNotSplit","pass":true,"statements":[{"sl":62},{"sl":63},{"sl":64},{"sl":152},{"sl":153}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [21, 22, 46, 15, 1, 45, 6, 41, 36, 26, 7, 38, 35, 39], [], [], [], [21, 22, 46, 15, 1, 45, 6, 41, 36, 26, 7, 38, 35, 39], [21, 22, 46, 15, 1, 45, 6, 41, 36, 26, 7, 38, 35, 39], [21, 22, 46, 15, 1, 45, 6, 41, 36, 26, 7, 38, 35, 39], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [21, 1, 45, 36, 26, 38], [], [], [], [], [21, 1, 45, 36, 26, 38], [21, 1, 45, 36, 26, 38], [21, 1, 45, 36, 26, 38], [21, 1, 45, 36, 26, 38], [], [], [21, 1, 45, 36, 26, 38], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [1, 45, 36, 26, 38], [], [], [], [], [1, 45, 36, 26, 38], [1, 45, 36, 26, 38], [1, 45, 36, 26, 38], [], [1, 45, 36, 26, 38], [1, 45, 36, 26, 38], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [21, 22, 46, 15, 1, 45, 6, 41, 36, 26, 7, 38, 35, 39], [21, 22, 46, 15, 1, 45, 6, 41, 36, 26, 7, 38, 35, 39], [21, 22, 46, 15, 1, 45, 6, 41, 36, 26, 7, 38, 35, 39], [], [], [], [], [], []]