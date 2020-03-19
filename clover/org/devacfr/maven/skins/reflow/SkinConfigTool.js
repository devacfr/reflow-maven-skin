var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":779,"id":472,"methods":[{"el":246,"sc":5,"sl":135},{"el":257,"sc":5,"sl":255},{"el":265,"sc":5,"sl":263},{"el":279,"sc":5,"sl":270},{"el":292,"sc":5,"sl":284},{"el":303,"sc":5,"sl":297},{"el":320,"sc":5,"sl":308},{"el":342,"sc":5,"sl":331},{"el":379,"sc":5,"sl":358},{"el":392,"sc":5,"sl":390},{"el":453,"sc":5,"sl":410},{"el":481,"sc":5,"sl":458},{"el":495,"sc":5,"sl":493},{"el":503,"sc":5,"sl":500},{"el":518,"sc":5,"sl":516},{"el":527,"sc":5,"sl":523},{"el":536,"sc":5,"sl":532},{"el":545,"sc":5,"sl":541},{"el":552,"sc":5,"sl":550},{"el":561,"sc":5,"sl":557},{"el":570,"sc":5,"sl":566},{"el":579,"sc":5,"sl":575},{"el":588,"sc":5,"sl":584},{"el":597,"sc":5,"sl":593},{"el":612,"sc":5,"sl":602},{"el":625,"sc":5,"sl":622},{"el":634,"sc":5,"sl":630},{"el":652,"sc":5,"sl":639},{"el":698,"sc":5,"sl":657},{"el":716,"sc":5,"sl":705},{"el":730,"sc":5,"sl":721},{"el":759,"sc":5,"sl":739},{"el":777,"sc":5,"sl":764}],"name":"SkinConfigTool","sl":86}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_24":{"methods":[{"sl":308},{"sl":331},{"sl":516}],"name":"testIsValue","pass":true,"statements":[{"sl":311},{"sl":313},{"sl":314},{"sl":316},{"sl":319},{"sl":333},{"sl":334},{"sl":336},{"sl":341},{"sl":517}]},"test_34":{"methods":[{"sl":308},{"sl":331},{"sl":493}],"name":"testIs","pass":true,"statements":[{"sl":311},{"sl":313},{"sl":314},{"sl":316},{"sl":319},{"sl":333},{"sl":334},{"sl":336},{"sl":341},{"sl":494}]},"test_51":{"methods":[{"sl":739}],"name":"testSlugFilename","pass":true,"statements":[{"sl":741},{"sl":744},{"sl":747},{"sl":748},{"sl":749},{"sl":758}]},"test_6":{"methods":[{"sl":308},{"sl":331},{"sl":705}],"name":"testIsExternalLink","pass":true,"statements":[{"sl":311},{"sl":313},{"sl":314},{"sl":316},{"sl":319},{"sl":333},{"sl":334},{"sl":336},{"sl":341},{"sl":706},{"sl":707},{"sl":709},{"sl":710},{"sl":711},{"sl":713}]},"test_61":{"methods":[{"sl":739}],"name":"shouldBuildFrameContext","pass":true,"statements":[{"sl":741},{"sl":744},{"sl":747},{"sl":748},{"sl":749},{"sl":758}]},"test_66":{"methods":[{"sl":721}],"name":"testIsActiveLink","pass":true,"statements":[{"sl":723},{"sl":724},{"sl":725},{"sl":729}]},"test_7":{"methods":[{"sl":308},{"sl":331},{"sl":500}],"name":"testNot","pass":true,"statements":[{"sl":311},{"sl":313},{"sl":314},{"sl":316},{"sl":319},{"sl":333},{"sl":334},{"sl":336},{"sl":341},{"sl":502}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [6, 34, 24, 7], [], [], [6, 34, 24, 7], [], [6, 34, 24, 7], [6, 34, 24, 7], [], [6, 34, 24, 7], [], [], [6, 34, 24, 7], [], [], [], [], [], [], [], [], [], [], [], [6, 34, 24, 7], [], [6, 34, 24, 7], [6, 34, 24, 7], [], [6, 34, 24, 7], [], [], [], [], [6, 34, 24, 7], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [34], [34], [], [], [], [], [], [7], [], [7], [], [], [], [], [], [], [], [], [], [], [], [], [], [24], [24], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [6], [6], [6], [], [6], [6], [6], [], [6], [], [], [], [], [], [], [], [66], [], [66], [66], [66], [], [], [], [66], [], [], [], [], [], [], [], [], [], [61, 51], [], [61, 51], [], [], [61, 51], [], [], [61, 51], [61, 51], [61, 51], [], [], [], [], [], [], [], [], [61, 51], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], []]