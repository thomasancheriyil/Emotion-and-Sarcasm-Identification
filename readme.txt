Tools required:
	Eclipse Kepler SDK for the project.
	xampp for the database connection used in Question Generation process.

Steps to run the "grouping of topics based on emotion and sarcasm in social networking sites"
Crawling
1. Project name: Crawler	Java file: Crawler.java
	While running crawler.java, seed URL and output file name (eg: crawl.txt) must be entered. The crawled data will be stored in the output file mentioned(crawl.txt).
Feature Extraction
2. Project name: TaggerDemo	Java file: TaggerDemo.java
	While running TaggerDemo.java, enter the crawled file name (crawl.txt) and output file name (emotionpos.txt). The crawl data will be POS tagged and stored in the output file mentioned.
3. Project name: TaggerDemo	Java file: crftraininput.java
	While running crftraininput.java, enter the POS tagged file name (emotionpos.txt) and output file name (emotionfeature.txt). Feature extraction is done to the output of POS tagger to consider only the verbs, adjectives and adverbs for emotion analysis.
Emotion Analysis
4. Emotion Analysis using CRF tool:
	1. Open command prompt and set the path to the location containing CRF tool (eg: C:\CRF++-0.58\CRF++-0.58)
	2. In the command prompt window, enter "crf_test -m model.txt (output of feature extraction) > (output file)". Eg: crf_test -m model.txt emotionfeature.txt > emotionoutput.txt. The output file will contain the emotion identified.
5. Project name: EmotionDisambi	    Java file: EmotionDisambi.java
	While running EmotionDismabi.java, enter the output of emotion analysis (emotionoutput.txt) and the name of output file(emotiondisambi.txt). The dominant emotion present in each post will be identified.
Sarcasm Analysis using corpus
6. Project name: OpenEphyra-0.1.1   Java file: OpenAryhpe.java
	This module is the sarcasm detection for the crawled data. While running OpenAryhpe.java, you will be prompted to enter the input and output files in the format of "file: (input file).txt (output file).txt". Eg: file: crawl.txt output.txt. output.txt will have all the output questions and the file, myoutput1.txt, will have all the yes/no questions.
7. Project name: DbEntry	Java file: DbEntry2.java
	While running DbEntry2.java, enter the output of question generator (myoutput1.txt) and the sarcasm output file. (sarcasmoutput1.txt). The sarcasm output will be stored in the output file post-wise.
Sarcasm Analysis by splitting sentences
8. Project name: TaggerDemo	Java file: SarcasmSeperation.java
	While running SarcasmSeperation.java, enter the crawl output (crawl.txt) and the two output parts(emotionpos1.txt, emotionpos2.txt). The two output files will have the split sentences.
9. Do the Feature Extraction and Emotion Analysis(steps 2,3,4,5) for the two output parts.
10. Project name: EmotionDisambi	Java file: SarEmoCombi.java
	While running SarEmoCombi.java, enter the emotion output files for the two parts(emotionoutput1.txt, emotionoutput2.txt) and the sarcasm output (sarcasmoutput2.txt). If there are opposite poled emotions, then it contains sarcasm.
11. Project name: EmotionDisambi	Java file: SarOutputCombi.java
	While running SarOutputCombi.java, enter the output files for both sarcasm analysis methods(sarcasmoutput1.txt, sarcasmoutput2.txt) and the output file(sarcasmoutput.txt). The sarcasm outputs will be combined into one file.
Emotion Classification and Trending Tab
12. Project name: EmotionDisambi	Java file: EmotionClassi.java
	While running EmotionClassi.java, enter the crawl output(crawl.txt), main emotion output(emotionoutput.txt), the final sarcasm output(sarcasmoutput.txt) and the output file(finaloutput.txt). The various posts will be classified according to the emotion and sarcasm and the output file will have all the classified posts.
13. Project name: ui	Java file: Ui.java
	While running Ui.java, enter the emotion and sarcasm classified file(finaloutput.txt) as the input. The trending tab will be displayed with the posts classified according to the emotion and sarcasm present.


Emotion training method:
1. Open command prompt and set the path to the location containing CRF tool (eg: C:\CRF++-0.58\CRF++-0.58)
2. The command to train the CRF is "crf_learn template1.txt (training file) model.txt". Eg: crf_learn template1.txt training.txt model.txt. training.txt will have the words with which CRF should be trained along with their correct emotion.

Sarcasm Training method:
1. Do the Question generation for the sentences which should be trained(Step 6).
2. Project name: DbEntry	Java file: DbEntry.java
	Use the "myoutput1.txt" file generated during question generation. While running DbEntry.java, the yes/no questions will be asked and the correct answer should be entered. The Database will now have the questions and the respective correct answers.