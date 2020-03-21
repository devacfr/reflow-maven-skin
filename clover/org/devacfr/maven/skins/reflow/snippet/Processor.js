var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":288,"id":1826,"methods":[{"el":51,"sc":5,"sl":49},{"el":82,"sc":5,"sl":59},{"el":127,"sc":5,"sl":94},{"el":181,"sc":5,"sl":150},{"el":198,"sc":5,"sl":193},{"el":217,"sc":5,"sl":207}],"name":"Processor","sl":38},{"el":262,"id":1918,"methods":[{"el":235,"sc":9,"sl":233},{"el":260,"sc":9,"sl":240}],"name":"Processor.WebComponentProcessor","sl":225},{"el":287,"id":1942,"methods":[{"el":280,"sc":9,"sl":278},{"el":285,"sc":9,"sl":282}],"name":"Processor.ShortcodeProcessor","sl":270}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_4":{"methods":[{"sl":49},{"sl":59},{"sl":94},{"sl":150},{"sl":193},{"sl":207},{"sl":233},{"sl":240},{"sl":278},{"sl":282}],"name":"shouldReplaceSnippetByHtml","pass":true,"statements":[{"sl":50},{"sl":60},{"sl":65},{"sl":66},{"sl":67},{"sl":68},{"sl":70},{"sl":71},{"sl":72},{"sl":76},{"sl":77},{"sl":95},{"sl":96},{"sl":97},{"sl":98},{"sl":99},{"sl":100},{"sl":101},{"sl":103},{"sl":104},{"sl":106},{"sl":107},{"sl":109},{"sl":110},{"sl":113},{"sl":118},{"sl":119},{"sl":151},{"sl":152},{"sl":153},{"sl":154},{"sl":156},{"sl":157},{"sl":159},{"sl":160},{"sl":161},{"sl":162},{"sl":163},{"sl":164},{"sl":166},{"sl":167},{"sl":168},{"sl":173},{"sl":174},{"sl":177},{"sl":179},{"sl":180},{"sl":195},{"sl":196},{"sl":197},{"sl":208},{"sl":234},{"sl":242},{"sl":243},{"sl":245},{"sl":246},{"sl":255},{"sl":256},{"sl":257},{"sl":258},{"sl":279},{"sl":284}]},"test_50":{"methods":[{"sl":49},{"sl":59},{"sl":94},{"sl":150},{"sl":193},{"sl":207},{"sl":233},{"sl":240},{"sl":278},{"sl":282}],"name":"shouldRenderLayout","pass":true,"statements":[{"sl":50},{"sl":60},{"sl":65},{"sl":66},{"sl":67},{"sl":68},{"sl":70},{"sl":71},{"sl":72},{"sl":76},{"sl":77},{"sl":95},{"sl":96},{"sl":97},{"sl":98},{"sl":99},{"sl":100},{"sl":101},{"sl":103},{"sl":104},{"sl":106},{"sl":107},{"sl":109},{"sl":110},{"sl":113},{"sl":118},{"sl":119},{"sl":151},{"sl":152},{"sl":153},{"sl":154},{"sl":156},{"sl":157},{"sl":159},{"sl":160},{"sl":161},{"sl":162},{"sl":163},{"sl":164},{"sl":166},{"sl":167},{"sl":168},{"sl":173},{"sl":174},{"sl":177},{"sl":179},{"sl":180},{"sl":195},{"sl":196},{"sl":197},{"sl":208},{"sl":234},{"sl":242},{"sl":243},{"sl":245},{"sl":246},{"sl":255},{"sl":257},{"sl":258},{"sl":279},{"sl":284}]},"test_59":{"methods":[{"sl":49},{"sl":59},{"sl":94},{"sl":150},{"sl":193},{"sl":207},{"sl":233},{"sl":278}],"name":"shouldRenderBadge","pass":true,"statements":[{"sl":50},{"sl":60},{"sl":61},{"sl":62},{"sl":63},{"sl":95},{"sl":96},{"sl":97},{"sl":98},{"sl":115},{"sl":118},{"sl":119},{"sl":151},{"sl":152},{"sl":153},{"sl":156},{"sl":157},{"sl":159},{"sl":160},{"sl":179},{"sl":180},{"sl":195},{"sl":196},{"sl":197},{"sl":208},{"sl":234},{"sl":279}]},"test_67":{"methods":[{"sl":49},{"sl":59},{"sl":94},{"sl":150},{"sl":193},{"sl":207},{"sl":233},{"sl":240},{"sl":278},{"sl":282}],"name":"shouldRenderCard","pass":true,"statements":[{"sl":50},{"sl":60},{"sl":65},{"sl":66},{"sl":67},{"sl":68},{"sl":70},{"sl":71},{"sl":72},{"sl":76},{"sl":77},{"sl":95},{"sl":96},{"sl":97},{"sl":98},{"sl":99},{"sl":100},{"sl":101},{"sl":103},{"sl":104},{"sl":106},{"sl":107},{"sl":109},{"sl":110},{"sl":113},{"sl":118},{"sl":119},{"sl":151},{"sl":152},{"sl":153},{"sl":154},{"sl":156},{"sl":157},{"sl":159},{"sl":160},{"sl":161},{"sl":162},{"sl":163},{"sl":164},{"sl":166},{"sl":167},{"sl":168},{"sl":173},{"sl":174},{"sl":177},{"sl":179},{"sl":180},{"sl":195},{"sl":196},{"sl":197},{"sl":208},{"sl":234},{"sl":242},{"sl":243},{"sl":245},{"sl":249},{"sl":250},{"sl":255},{"sl":256},{"sl":257},{"sl":258},{"sl":279},{"sl":284}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [50, 59, 67, 4], [50, 59, 67, 4], [], [], [], [], [], [], [], [], [50, 59, 67, 4], [50, 59, 67, 4], [59], [59], [59], [], [50, 67, 4], [50, 67, 4], [50, 67, 4], [50, 67, 4], [], [50, 67, 4], [50, 67, 4], [50, 67, 4], [], [], [], [50, 67, 4], [50, 67, 4], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [50, 59, 67, 4], [50, 59, 67, 4], [50, 59, 67, 4], [50, 59, 67, 4], [50, 59, 67, 4], [50, 67, 4], [50, 67, 4], [50, 67, 4], [], [50, 67, 4], [50, 67, 4], [], [50, 67, 4], [50, 67, 4], [], [50, 67, 4], [50, 67, 4], [], [], [50, 67, 4], [], [59], [], [], [50, 59, 67, 4], [50, 59, 67, 4], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [50, 59, 67, 4], [50, 59, 67, 4], [50, 59, 67, 4], [50, 59, 67, 4], [50, 67, 4], [], [50, 59, 67, 4], [50, 59, 67, 4], [], [50, 59, 67, 4], [50, 59, 67, 4], [50, 67, 4], [50, 67, 4], [50, 67, 4], [50, 67, 4], [], [50, 67, 4], [50, 67, 4], [50, 67, 4], [], [], [], [], [50, 67, 4], [50, 67, 4], [], [], [50, 67, 4], [], [50, 59, 67, 4], [50, 59, 67, 4], [], [], [], [], [], [], [], [], [], [], [], [], [50, 59, 67, 4], [], [50, 59, 67, 4], [50, 59, 67, 4], [50, 59, 67, 4], [], [], [], [], [], [], [], [], [], [50, 59, 67, 4], [50, 59, 67, 4], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [50, 59, 67, 4], [50, 59, 67, 4], [], [], [], [], [], [50, 67, 4], [], [50, 67, 4], [50, 67, 4], [], [50, 67, 4], [50, 4], [], [], [67], [67], [], [], [], [], [50, 67, 4], [67, 4], [50, 67, 4], [50, 67, 4], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [50, 59, 67, 4], [50, 59, 67, 4], [], [], [50, 67, 4], [], [50, 67, 4], [], [], [], []]