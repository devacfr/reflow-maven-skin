var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":202,"id":1867,"methods":[{"el":54,"sc":5,"sl":45},{"el":101,"sc":5,"sl":59},{"el":120,"sc":5,"sl":103},{"el":144,"sc":5,"sl":122},{"el":201,"sc":5,"sl":146}],"name":"ContextTest","sl":40}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_27":{"methods":[{"sl":146}],"name":"shouldBuildFrameContext","pass":true,"statements":[{"sl":149},{"sl":151},{"sl":154},{"sl":163},{"sl":164},{"sl":165},{"sl":166},{"sl":167},{"sl":169},{"sl":170},{"sl":171},{"sl":173},{"sl":175},{"sl":176},{"sl":177},{"sl":179},{"sl":180},{"sl":181},{"sl":182},{"sl":185},{"sl":186},{"sl":187},{"sl":188},{"sl":190},{"sl":191},{"sl":192},{"sl":193},{"sl":195},{"sl":196},{"sl":197},{"sl":198},{"sl":199}]},"test_35":{"methods":[{"sl":122}],"name":"shouldBuildDocumentContext","pass":true,"statements":[{"sl":125},{"sl":127},{"sl":130},{"sl":131},{"sl":133},{"sl":134},{"sl":136},{"sl":138},{"sl":139},{"sl":140},{"sl":142},{"sl":143}]},"test_39":{"methods":[{"sl":103}],"name":"shouldBuildPageContextWithTocDisabled","pass":true,"statements":[{"sl":106},{"sl":108},{"sl":111},{"sl":112},{"sl":114},{"sl":116},{"sl":117},{"sl":118}]},"test_8":{"methods":[{"sl":59}],"name":"shouldBuildPageContext","pass":true,"statements":[{"sl":62},{"sl":64},{"sl":67},{"sl":69},{"sl":70},{"sl":72},{"sl":74},{"sl":75},{"sl":76},{"sl":77},{"sl":78},{"sl":79},{"sl":80},{"sl":82},{"sl":83},{"sl":84},{"sl":85},{"sl":87},{"sl":88},{"sl":89},{"sl":90},{"sl":92},{"sl":93},{"sl":94},{"sl":95},{"sl":96},{"sl":98},{"sl":99},{"sl":100}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [8], [], [], [8], [], [8], [], [], [8], [], [8], [8], [], [8], [], [8], [8], [8], [8], [8], [8], [8], [], [8], [8], [8], [8], [], [8], [8], [8], [8], [], [8], [8], [8], [8], [8], [], [8], [8], [8], [], [], [39], [], [], [39], [], [39], [], [], [39], [39], [], [39], [], [39], [39], [39], [], [], [], [35], [], [], [35], [], [35], [], [], [35], [35], [], [35], [35], [], [35], [], [35], [35], [35], [], [35], [35], [], [], [27], [], [], [27], [], [27], [], [], [27], [], [], [], [], [], [], [], [], [27], [27], [27], [27], [27], [], [27], [27], [27], [], [27], [], [27], [27], [27], [], [27], [27], [27], [27], [], [], [27], [27], [27], [27], [], [27], [27], [27], [27], [], [27], [27], [27], [27], [27], [], [], []]