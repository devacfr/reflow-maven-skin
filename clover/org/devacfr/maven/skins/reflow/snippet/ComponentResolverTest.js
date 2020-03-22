var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":83,"id":2631,"methods":[{"el":32,"sc":5,"sl":29},{"el":37,"sc":5,"sl":34},{"el":42,"sc":5,"sl":39},{"el":47,"sc":5,"sl":44},{"el":52,"sc":5,"sl":49},{"el":57,"sc":5,"sl":54},{"el":64,"sc":5,"sl":59},{"el":69,"sc":5,"sl":66},{"el":74,"sc":5,"sl":71},{"el":81,"sc":5,"sl":76}],"name":"ComponentResolverTest","sl":27}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_10":{"methods":[{"sl":29},{"sl":76}],"name":"shouldBeStartWebComponent","pass":true,"statements":[{"sl":31},{"sl":77},{"sl":78},{"sl":79},{"sl":80}]},"test_15":{"methods":[{"sl":49},{"sl":76}],"name":"shouldBeEndShortcode","pass":true,"statements":[{"sl":51},{"sl":77},{"sl":78},{"sl":79},{"sl":80}]},"test_30":{"methods":[{"sl":59}],"name":"shouldFailedOnMalformed","pass":true,"statements":[{"sl":61},{"sl":62}]},"test_35":{"methods":[{"sl":34},{"sl":76}],"name":"shouldBeEndWebComponent","pass":true,"statements":[{"sl":36},{"sl":77},{"sl":78},{"sl":79},{"sl":80}]},"test_38":{"methods":[{"sl":71},{"sl":76}],"name":"shouldElementStartWebComponentContainingAttributes","pass":true,"statements":[{"sl":73},{"sl":77},{"sl":78},{"sl":79},{"sl":80}]},"test_44":{"methods":[{"sl":44},{"sl":76}],"name":"shouldBeStartShortcode","pass":true,"statements":[{"sl":46},{"sl":77},{"sl":78},{"sl":79},{"sl":80}]},"test_48":{"methods":[{"sl":39},{"sl":76}],"name":"shouldBeEmptyWebComponent","pass":true,"statements":[{"sl":41},{"sl":77},{"sl":78},{"sl":79},{"sl":80}]},"test_50":{"methods":[{"sl":54},{"sl":76}],"name":"shouldBeEmptyShortcode","pass":true,"statements":[{"sl":56},{"sl":77},{"sl":78},{"sl":79},{"sl":80}]},"test_70":{"methods":[{"sl":66}],"name":"shouldFailedUnknownComponent","pass":true,"statements":[{"sl":68}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [10], [], [10], [], [], [35], [], [35], [], [], [48], [], [48], [], [], [44], [], [44], [], [], [15], [], [15], [], [], [50], [], [50], [], [], [30], [], [30], [30], [], [], [], [70], [], [70], [], [], [38], [], [38], [], [], [15, 38, 44, 50, 10, 35, 48], [15, 38, 44, 50, 10, 35, 48], [15, 38, 44, 50, 10, 35, 48], [15, 38, 44, 50, 10, 35, 48], [15, 38, 44, 50, 10, 35, 48], [], [], []]