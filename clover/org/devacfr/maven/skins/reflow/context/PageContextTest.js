var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":110,"id":2789,"methods":[{"el":56,"sc":5,"sl":42},{"el":97,"sc":5,"sl":61},{"el":109,"sc":5,"sl":99}],"name":"PageContextTest","sl":37}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_12":{"methods":[{"sl":99}],"name":"shouldBuildPageContextWithTocDisabled","pass":true,"statements":[{"sl":101},{"sl":102},{"sl":104},{"sl":106},{"sl":107},{"sl":108}]},"test_60":{"methods":[{"sl":61}],"name":"shouldBuildPageContext","pass":true,"statements":[{"sl":63},{"sl":65},{"sl":66},{"sl":68},{"sl":70},{"sl":71},{"sl":72},{"sl":73},{"sl":74},{"sl":75},{"sl":76},{"sl":78},{"sl":79},{"sl":80},{"sl":81},{"sl":83},{"sl":84},{"sl":85},{"sl":86},{"sl":88},{"sl":89},{"sl":90},{"sl":91},{"sl":92},{"sl":94},{"sl":95},{"sl":96}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [60], [], [60], [], [60], [60], [], [60], [], [60], [60], [60], [60], [60], [60], [60], [], [60], [60], [60], [60], [], [60], [60], [60], [60], [], [60], [60], [60], [60], [60], [], [60], [60], [60], [], [], [12], [], [12], [12], [], [12], [], [12], [12], [12], [], []]