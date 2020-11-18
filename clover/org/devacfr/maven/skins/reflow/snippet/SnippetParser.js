var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":152,"id":2193,"methods":[{"el":70,"sc":5,"sl":64},{"el":75,"sc":5,"sl":72},{"el":80,"sc":5,"sl":77},{"el":105,"sc":5,"sl":82},{"el":128,"sc":5,"sl":107},{"el":132,"sc":5,"sl":130},{"el":137,"sc":5,"sl":134},{"el":142,"sc":5,"sl":139},{"el":146,"sc":5,"sl":144},{"el":150,"sc":5,"sl":148}],"name":"SnippetParser","sl":38}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_4":{"methods":[{"sl":64},{"sl":72},{"sl":82},{"sl":107},{"sl":130},{"sl":139},{"sl":144},{"sl":148}],"name":"shouldRenderNestedComponent","pass":true,"statements":[{"sl":65},{"sl":66},{"sl":67},{"sl":68},{"sl":69},{"sl":73},{"sl":74},{"sl":84},{"sl":85},{"sl":87},{"sl":88},{"sl":91},{"sl":93},{"sl":95},{"sl":96},{"sl":97},{"sl":103},{"sl":104},{"sl":108},{"sl":111},{"sl":112},{"sl":113},{"sl":116},{"sl":117},{"sl":118},{"sl":119},{"sl":126},{"sl":127},{"sl":131},{"sl":140},{"sl":141},{"sl":145},{"sl":149}]},"test_49":{"methods":[{"sl":64},{"sl":72},{"sl":82},{"sl":107},{"sl":130},{"sl":139},{"sl":144},{"sl":148}],"name":"shouldRenderCard","pass":true,"statements":[{"sl":65},{"sl":66},{"sl":67},{"sl":68},{"sl":69},{"sl":73},{"sl":74},{"sl":84},{"sl":85},{"sl":87},{"sl":88},{"sl":91},{"sl":93},{"sl":95},{"sl":96},{"sl":97},{"sl":103},{"sl":104},{"sl":108},{"sl":111},{"sl":112},{"sl":113},{"sl":116},{"sl":117},{"sl":118},{"sl":119},{"sl":120},{"sl":121},{"sl":122},{"sl":126},{"sl":127},{"sl":131},{"sl":140},{"sl":141},{"sl":145},{"sl":149}]},"test_57":{"methods":[{"sl":64},{"sl":72},{"sl":77},{"sl":82},{"sl":107},{"sl":130},{"sl":139},{"sl":144},{"sl":148}],"name":"shouldRenderCardRecursively","pass":true,"statements":[{"sl":65},{"sl":66},{"sl":67},{"sl":68},{"sl":69},{"sl":73},{"sl":74},{"sl":78},{"sl":79},{"sl":84},{"sl":85},{"sl":87},{"sl":88},{"sl":91},{"sl":93},{"sl":95},{"sl":96},{"sl":97},{"sl":103},{"sl":104},{"sl":108},{"sl":111},{"sl":112},{"sl":113},{"sl":116},{"sl":117},{"sl":118},{"sl":119},{"sl":120},{"sl":121},{"sl":122},{"sl":126},{"sl":127},{"sl":131},{"sl":140},{"sl":141},{"sl":145},{"sl":149}]},"test_59":{"methods":[{"sl":64},{"sl":72},{"sl":82},{"sl":107},{"sl":130},{"sl":139},{"sl":144},{"sl":148}],"name":"shouldRenderBadge","pass":true,"statements":[{"sl":65},{"sl":66},{"sl":67},{"sl":68},{"sl":69},{"sl":73},{"sl":74},{"sl":84},{"sl":85},{"sl":87},{"sl":88},{"sl":91},{"sl":93},{"sl":95},{"sl":96},{"sl":97},{"sl":103},{"sl":104},{"sl":108},{"sl":111},{"sl":112},{"sl":113},{"sl":116},{"sl":117},{"sl":118},{"sl":119},{"sl":120},{"sl":121},{"sl":122},{"sl":126},{"sl":127},{"sl":131},{"sl":140},{"sl":141},{"sl":145},{"sl":149}]},"test_60":{"methods":[{"sl":64},{"sl":72},{"sl":82},{"sl":107},{"sl":130},{"sl":139},{"sl":144},{"sl":148}],"name":"shouldReplaceSnippetByHtml","pass":true,"statements":[{"sl":65},{"sl":66},{"sl":67},{"sl":68},{"sl":69},{"sl":73},{"sl":74},{"sl":84},{"sl":85},{"sl":87},{"sl":88},{"sl":91},{"sl":93},{"sl":95},{"sl":96},{"sl":97},{"sl":103},{"sl":104},{"sl":108},{"sl":111},{"sl":112},{"sl":113},{"sl":116},{"sl":117},{"sl":118},{"sl":119},{"sl":120},{"sl":121},{"sl":122},{"sl":126},{"sl":127},{"sl":131},{"sl":140},{"sl":141},{"sl":145},{"sl":149}]},"test_68":{"methods":[{"sl":64},{"sl":72},{"sl":82},{"sl":107},{"sl":130},{"sl":139},{"sl":144},{"sl":148}],"name":"shouldRenderLayout","pass":true,"statements":[{"sl":65},{"sl":66},{"sl":67},{"sl":68},{"sl":69},{"sl":73},{"sl":74},{"sl":84},{"sl":85},{"sl":87},{"sl":88},{"sl":91},{"sl":93},{"sl":95},{"sl":96},{"sl":97},{"sl":103},{"sl":104},{"sl":108},{"sl":111},{"sl":112},{"sl":113},{"sl":116},{"sl":117},{"sl":118},{"sl":119},{"sl":120},{"sl":121},{"sl":122},{"sl":126},{"sl":127},{"sl":131},{"sl":140},{"sl":141},{"sl":145},{"sl":149}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [59, 57, 68, 49, 60, 4], [59, 57, 68, 49, 60, 4], [59, 57, 68, 49, 60, 4], [59, 57, 68, 49, 60, 4], [59, 57, 68, 49, 60, 4], [59, 57, 68, 49, 60, 4], [], [], [59, 57, 68, 49, 60, 4], [59, 57, 68, 49, 60, 4], [59, 57, 68, 49, 60, 4], [], [], [57], [57], [57], [], [], [59, 57, 68, 49, 60, 4], [], [59, 57, 68, 49, 60, 4], [59, 57, 68, 49, 60, 4], [], [59, 57, 68, 49, 60, 4], [59, 57, 68, 49, 60, 4], [], [], [59, 57, 68, 49, 60, 4], [], [59, 57, 68, 49, 60, 4], [], [59, 57, 68, 49, 60, 4], [59, 57, 68, 49, 60, 4], [59, 57, 68, 49, 60, 4], [], [], [], [], [], [59, 57, 68, 49, 60, 4], [59, 57, 68, 49, 60, 4], [], [], [59, 57, 68, 49, 60, 4], [59, 57, 68, 49, 60, 4], [], [], [59, 57, 68, 49, 60, 4], [59, 57, 68, 49, 60, 4], [59, 57, 68, 49, 60, 4], [], [], [59, 57, 68, 49, 60, 4], [59, 57, 68, 49, 60, 4], [59, 57, 68, 49, 60, 4], [59, 57, 68, 49, 60, 4], [59, 57, 68, 49, 60], [59, 57, 68, 49, 60], [59, 57, 68, 49, 60], [], [], [], [59, 57, 68, 49, 60, 4], [59, 57, 68, 49, 60, 4], [], [], [59, 57, 68, 49, 60, 4], [59, 57, 68, 49, 60, 4], [], [], [], [], [], [], [], [59, 57, 68, 49, 60, 4], [59, 57, 68, 49, 60, 4], [59, 57, 68, 49, 60, 4], [], [], [59, 57, 68, 49, 60, 4], [59, 57, 68, 49, 60, 4], [], [], [59, 57, 68, 49, 60, 4], [59, 57, 68, 49, 60, 4], [], [], []]