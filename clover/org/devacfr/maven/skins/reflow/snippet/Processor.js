var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":282,"id":1849,"methods":[{"el":50,"sc":5,"sl":48},{"el":81,"sc":5,"sl":58},{"el":126,"sc":5,"sl":93},{"el":180,"sc":5,"sl":149},{"el":197,"sc":5,"sl":192},{"el":216,"sc":5,"sl":206}],"name":"Processor","sl":37},{"el":256,"id":1941,"methods":[{"el":234,"sc":9,"sl":232},{"el":254,"sc":9,"sl":239}],"name":"Processor.WebComponentProcessor","sl":224},{"el":281,"id":1961,"methods":[{"el":274,"sc":9,"sl":272},{"el":279,"sc":9,"sl":276}],"name":"Processor.ShortcodeProcessor","sl":264}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_17":{"methods":[{"sl":48},{"sl":58},{"sl":93},{"sl":149},{"sl":192},{"sl":206},{"sl":232},{"sl":239},{"sl":272},{"sl":276}],"name":"shouldRenderLayout","pass":true,"statements":[{"sl":49},{"sl":59},{"sl":64},{"sl":65},{"sl":66},{"sl":67},{"sl":69},{"sl":70},{"sl":71},{"sl":75},{"sl":76},{"sl":94},{"sl":95},{"sl":96},{"sl":97},{"sl":98},{"sl":99},{"sl":100},{"sl":102},{"sl":103},{"sl":105},{"sl":106},{"sl":108},{"sl":109},{"sl":112},{"sl":117},{"sl":118},{"sl":150},{"sl":151},{"sl":152},{"sl":153},{"sl":155},{"sl":156},{"sl":158},{"sl":159},{"sl":160},{"sl":161},{"sl":162},{"sl":163},{"sl":165},{"sl":166},{"sl":167},{"sl":172},{"sl":173},{"sl":176},{"sl":178},{"sl":179},{"sl":194},{"sl":195},{"sl":196},{"sl":207},{"sl":233},{"sl":241},{"sl":242},{"sl":244},{"sl":245},{"sl":249},{"sl":251},{"sl":252},{"sl":273},{"sl":278}]},"test_30":{"methods":[{"sl":48},{"sl":58},{"sl":93},{"sl":149},{"sl":192},{"sl":206},{"sl":232},{"sl":239},{"sl":272},{"sl":276}],"name":"shouldReplaceSnippetByHtml","pass":true,"statements":[{"sl":49},{"sl":59},{"sl":64},{"sl":65},{"sl":66},{"sl":67},{"sl":69},{"sl":70},{"sl":71},{"sl":75},{"sl":76},{"sl":94},{"sl":95},{"sl":96},{"sl":97},{"sl":98},{"sl":99},{"sl":100},{"sl":102},{"sl":103},{"sl":105},{"sl":106},{"sl":108},{"sl":109},{"sl":112},{"sl":117},{"sl":118},{"sl":150},{"sl":151},{"sl":152},{"sl":153},{"sl":155},{"sl":156},{"sl":158},{"sl":159},{"sl":160},{"sl":161},{"sl":162},{"sl":163},{"sl":165},{"sl":166},{"sl":167},{"sl":172},{"sl":173},{"sl":176},{"sl":178},{"sl":179},{"sl":194},{"sl":195},{"sl":196},{"sl":207},{"sl":233},{"sl":241},{"sl":242},{"sl":244},{"sl":245},{"sl":249},{"sl":250},{"sl":251},{"sl":252},{"sl":273},{"sl":278}]},"test_4":{"methods":[{"sl":48},{"sl":58},{"sl":93},{"sl":149},{"sl":192},{"sl":206},{"sl":232},{"sl":239},{"sl":272},{"sl":276}],"name":"shouldRenderCard","pass":true,"statements":[{"sl":49},{"sl":59},{"sl":64},{"sl":65},{"sl":66},{"sl":67},{"sl":69},{"sl":70},{"sl":71},{"sl":75},{"sl":76},{"sl":94},{"sl":95},{"sl":96},{"sl":97},{"sl":98},{"sl":99},{"sl":100},{"sl":102},{"sl":103},{"sl":105},{"sl":106},{"sl":108},{"sl":109},{"sl":112},{"sl":117},{"sl":118},{"sl":150},{"sl":151},{"sl":152},{"sl":153},{"sl":155},{"sl":156},{"sl":158},{"sl":159},{"sl":160},{"sl":161},{"sl":162},{"sl":163},{"sl":165},{"sl":166},{"sl":167},{"sl":172},{"sl":173},{"sl":176},{"sl":178},{"sl":179},{"sl":194},{"sl":195},{"sl":196},{"sl":207},{"sl":233},{"sl":241},{"sl":242},{"sl":244},{"sl":247},{"sl":249},{"sl":250},{"sl":251},{"sl":252},{"sl":273},{"sl":278}]},"test_46":{"methods":[{"sl":48},{"sl":58},{"sl":93},{"sl":149},{"sl":192},{"sl":206},{"sl":232},{"sl":272}],"name":"shouldRenderBadge","pass":true,"statements":[{"sl":49},{"sl":59},{"sl":60},{"sl":61},{"sl":62},{"sl":94},{"sl":95},{"sl":96},{"sl":97},{"sl":114},{"sl":117},{"sl":118},{"sl":150},{"sl":151},{"sl":152},{"sl":155},{"sl":156},{"sl":158},{"sl":159},{"sl":178},{"sl":179},{"sl":194},{"sl":195},{"sl":196},{"sl":207},{"sl":233},{"sl":273}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [17, 30, 46, 4], [17, 30, 46, 4], [], [], [], [], [], [], [], [], [17, 30, 46, 4], [17, 30, 46, 4], [46], [46], [46], [], [17, 30, 4], [17, 30, 4], [17, 30, 4], [17, 30, 4], [], [17, 30, 4], [17, 30, 4], [17, 30, 4], [], [], [], [17, 30, 4], [17, 30, 4], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [17, 30, 46, 4], [17, 30, 46, 4], [17, 30, 46, 4], [17, 30, 46, 4], [17, 30, 46, 4], [17, 30, 4], [17, 30, 4], [17, 30, 4], [], [17, 30, 4], [17, 30, 4], [], [17, 30, 4], [17, 30, 4], [], [17, 30, 4], [17, 30, 4], [], [], [17, 30, 4], [], [46], [], [], [17, 30, 46, 4], [17, 30, 46, 4], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [17, 30, 46, 4], [17, 30, 46, 4], [17, 30, 46, 4], [17, 30, 46, 4], [17, 30, 4], [], [17, 30, 46, 4], [17, 30, 46, 4], [], [17, 30, 46, 4], [17, 30, 46, 4], [17, 30, 4], [17, 30, 4], [17, 30, 4], [17, 30, 4], [], [17, 30, 4], [17, 30, 4], [17, 30, 4], [], [], [], [], [17, 30, 4], [17, 30, 4], [], [], [17, 30, 4], [], [17, 30, 46, 4], [17, 30, 46, 4], [], [], [], [], [], [], [], [], [], [], [], [], [17, 30, 46, 4], [], [17, 30, 46, 4], [17, 30, 46, 4], [17, 30, 46, 4], [], [], [], [], [], [], [], [], [], [17, 30, 46, 4], [17, 30, 46, 4], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [17, 30, 46, 4], [17, 30, 46, 4], [], [], [], [], [], [17, 30, 4], [], [17, 30, 4], [17, 30, 4], [], [17, 30, 4], [17, 30], [], [4], [], [17, 30, 4], [30, 4], [17, 30, 4], [17, 30, 4], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [17, 30, 46, 4], [17, 30, 46, 4], [], [], [17, 30, 4], [], [17, 30, 4], [], [], [], []]