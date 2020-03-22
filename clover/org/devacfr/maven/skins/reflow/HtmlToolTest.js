var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":259,"id":2185,"methods":[{"el":48,"sc":5,"sl":41},{"el":60,"sc":5,"sl":53},{"el":70,"sc":5,"sl":65},{"el":82,"sc":5,"sl":75},{"el":96,"sc":5,"sl":84},{"el":110,"sc":5,"sl":98},{"el":124,"sc":5,"sl":112},{"el":132,"sc":5,"sl":126},{"el":137,"sc":5,"sl":134},{"el":144,"sc":5,"sl":139},{"el":160,"sc":5,"sl":146},{"el":167,"sc":5,"sl":162},{"el":174,"sc":5,"sl":169},{"el":181,"sc":5,"sl":176},{"el":188,"sc":5,"sl":183},{"el":195,"sc":5,"sl":190},{"el":202,"sc":5,"sl":197},{"el":209,"sc":5,"sl":204},{"el":216,"sc":5,"sl":211},{"el":223,"sc":5,"sl":218},{"el":230,"sc":5,"sl":225},{"el":237,"sc":5,"sl":232},{"el":258,"sc":5,"sl":239}],"name":"HtmlToolTest","sl":37}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_12":{"methods":[{"sl":232}],"name":"shouldEnsureHeadingIdsForFrame","pass":true,"statements":[{"sl":234},{"sl":235}]},"test_14":{"methods":[{"sl":162}],"name":"shouldSetAttribute","pass":true,"statements":[{"sl":164},{"sl":165},{"sl":166}]},"test_17":{"methods":[{"sl":197}],"name":"shouldReplace","pass":true,"statements":[{"sl":199},{"sl":200},{"sl":201}]},"test_23":{"methods":[{"sl":225}],"name":"shouldEnsureHeadingIds","pass":true,"statements":[{"sl":227},{"sl":228}]},"test_24":{"methods":[{"sl":134}],"name":"fixTableHeadsWithTagListReportOuput","pass":true,"statements":[{"sl":136}]},"test_25":{"methods":[{"sl":218}],"name":"shouldHeadingAnchorToId","pass":true,"statements":[{"sl":220},{"sl":221}]},"test_28":{"methods":[{"sl":183}],"name":"shouldWrapElement","pass":true,"statements":[{"sl":185},{"sl":186},{"sl":187}]},"test_3":{"methods":[{"sl":84}],"name":"shouldSplitJoinSeparatorBefore","pass":true,"statements":[{"sl":86},{"sl":87},{"sl":88},{"sl":89},{"sl":90},{"sl":92},{"sl":93},{"sl":94},{"sl":95}]},"test_32":{"methods":[{"sl":169}],"name":"shouldgetAttribute","pass":true,"statements":[{"sl":171},{"sl":172},{"sl":173}]},"test_36":{"methods":[{"sl":176}],"name":"shouldAddClass","pass":true,"statements":[{"sl":178},{"sl":179},{"sl":180}]},"test_4":{"methods":[{"sl":126}],"name":"shouldSplitOnStarts","pass":true,"statements":[{"sl":128},{"sl":129},{"sl":130},{"sl":131}]},"test_43":{"methods":[{"sl":65}],"name":"shouldNotSplit","pass":true,"statements":[{"sl":67},{"sl":68},{"sl":69}]},"test_46":{"methods":[{"sl":139}],"name":"shouldReorderToTopOneSection","pass":true,"statements":[{"sl":141},{"sl":142}]},"test_49":{"methods":[{"sl":190}],"name":"shouldRemoveElement","pass":true,"statements":[{"sl":192},{"sl":193},{"sl":194}]},"test_51":{"methods":[{"sl":112}],"name":"shouldSplitJoinSeparatorNo","pass":true,"statements":[{"sl":114},{"sl":115},{"sl":116},{"sl":117},{"sl":118},{"sl":120},{"sl":121},{"sl":122},{"sl":123}]},"test_56":{"methods":[{"sl":204}],"name":"shouldReplaceWith","pass":true,"statements":[{"sl":206},{"sl":208}]},"test_58":{"methods":[{"sl":239}],"name":"shouldHeadingTree","pass":true,"statements":[{"sl":241},{"sl":243},{"sl":245},{"sl":247},{"sl":248},{"sl":252},{"sl":253},{"sl":255}]},"test_62":{"methods":[{"sl":53}],"name":"shouldSplitBodyFragment","pass":true,"statements":[{"sl":55},{"sl":56},{"sl":57},{"sl":58},{"sl":59}]},"test_63":{"methods":[{"sl":146}],"name":"shouldExtract","pass":true,"statements":[{"sl":148},{"sl":150},{"sl":151},{"sl":152},{"sl":153},{"sl":154},{"sl":158},{"sl":159}]},"test_65":{"methods":[{"sl":98}],"name":"shouldSplitJoinSeparatorAfter","pass":true,"statements":[{"sl":100},{"sl":101},{"sl":102},{"sl":103},{"sl":104},{"sl":106},{"sl":107},{"sl":108},{"sl":109}]},"test_8":{"methods":[{"sl":75}],"name":"shouldSplitRecursively","pass":true,"statements":[{"sl":77},{"sl":78},{"sl":79},{"sl":80},{"sl":81}]},"test_9":{"methods":[{"sl":211}],"name":"shouldExtractText","pass":true,"statements":[{"sl":213},{"sl":214},{"sl":215}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [62], [], [62], [62], [62], [62], [62], [], [], [], [], [], [43], [], [43], [43], [43], [], [], [], [], [], [8], [], [8], [8], [8], [8], [8], [], [], [3], [], [3], [3], [3], [3], [3], [], [3], [3], [3], [3], [], [], [65], [], [65], [65], [65], [65], [65], [], [65], [65], [65], [65], [], [], [51], [], [51], [51], [51], [51], [51], [], [51], [51], [51], [51], [], [], [4], [], [4], [4], [4], [4], [], [], [24], [], [24], [], [], [46], [], [46], [46], [], [], [], [63], [], [63], [], [63], [63], [63], [63], [63], [], [], [], [63], [63], [], [], [14], [], [14], [14], [14], [], [], [32], [], [32], [32], [32], [], [], [36], [], [36], [36], [36], [], [], [28], [], [28], [28], [28], [], [], [49], [], [49], [49], [49], [], [], [17], [], [17], [17], [17], [], [], [56], [], [56], [], [56], [], [], [9], [], [9], [9], [9], [], [], [25], [], [25], [25], [], [], [], [23], [], [23], [23], [], [], [], [12], [], [12], [12], [], [], [], [58], [], [58], [], [58], [], [58], [], [58], [58], [], [], [], [58], [58], [], [58], [], [], [], []]