/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50506
Source Host           : localhost:3306
Source Database       : cai

Target Server Type    : MYSQL
Target Server Version : 50506
File Encoding         : 65001

Date: 2019-06-12 15:09:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', '000000', '000000');

-- ----------------------------
-- Table structure for `cai`
-- ----------------------------
DROP TABLE IF EXISTS `cai`;
CREATE TABLE `cai` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cai_name` varchar(255) DEFAULT NULL,
  `cai_desc` varchar(255) DEFAULT NULL,
  `cai_class` varchar(255) DEFAULT NULL,
  `cai_raw` varchar(255) DEFAULT NULL,
  `cai_step` varchar(255) DEFAULT NULL,
  `cai_image_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of cai
-- ----------------------------
INSERT INTO `cai` VALUES ('1', '香辣毛血旺', '鲜辣美味，做法简单', '川菜', '鸭血：500克；萝卜：200克；豆芽：200克；花生油：3毫升；干辣椒：5克；豆瓣酱：20克；香葱：20克；盐：3克。', '（1）准备食材：鸭血、豆芽、白萝卜、香葱、辣椒、豆瓣酱等食材；\r\n（2）白萝卜去皮切丝，豆芽去根，洗净，辣椒切碎。\r\n（3）清水煮沸，把鸭血切块，放入锅中汆烫；\r\n（4）热锅，倒油，当然豆瓣酱、辣椒煸炒香味，加入水煮沸；\r\n（5）放入豆芽、萝卜丝；再把汆烫好的鸭血加入；\r\n（6）放盐、撒上葱花即可', 'xianglamaoxuewang.jpg');
INSERT INTO `cai` VALUES ('2', '四喜丸子', '四喜丸子是鲁菜的经典名菜', '鲁菜', '肉馅：500克；食用油：100克；盐：1克；味精：1克；姜：2片；大葱：1课；花椒：10粒；花椒水：20毫升；大料：2朵；鸡蛋：1个；淀粉：15克；面粉：15克；生抽：15毫升；酱油：15毫升；料酒：25毫升；白糖：15克；大蒜：4瓣；小油菜：5棵', '（1）肉馅加入花椒水，料酒，酱油，生抽，姜末，加入鸡蛋，淀粉，面粉，味精搅打上劲\r\n（2）制成四个大丸子\r\n（3）锅中多放点食用油，油大约7成热时下入丸子\r\n（4）炸制金黄色捞出控干油备用\r\n（5）锅底油，加入白糖冒小泡发黄时，加入大料，花椒加入葱姜蒜煸香\r\n（6）加入水，酱油，调口，大火烧开，中小火焖20分钟，汤汁浓稠时就可以了\r\n（7）油菜清洗干净，大的一切两开，放水开水锅中焯水\r\n（8）小油菜围边，丸子码放盘中，汤汁浇在丸子上', 'sixiwangzi.jpg');
INSERT INTO `cai` VALUES ('3', '双味卷肠粉', '广式特色小吃在家做！', '粤菜', '肠粉专用粉：100克；水：300克；生菜：1小颗；鸡蛋：1个；猪肉：50克', '（1）准备好做卷肠粉的材料和份量，将生菜洗净后切成丝\r\n（2）猪肉剁成肉泥\r\n（3）鸡蛋打散混合均匀\r\n（4）取一个干净的盆子，倒入100克的肠粉专用粉\r\n（5）肠粉专用粉和水按照1：3的比例加入300克水混合均匀\r\n（6）蒸肠粉用的容器底部刷一层油\r\n（7）把肠粉面糊倒入容器里，尽量的倒满\r\n（8）撒上肉沫，青菜和葱花\r\n（9）鸡蛋味的可以加上适量的蛋液\r\n（10）把肠粉半成品放入烧开水的锅里大火蒸\r\n（11）蒸到肠粉糊变白，猪肉变白就可以出锅了\r\n（12）用刮板从一侧铲好肠粉卷起来，就可以装盘开吃。', 'shuangweijaunchangfen.jpg');
INSERT INTO `cai` VALUES ('4', '东坡肉', '东坡肉的故事...', '浙菜', '五花肉：1500克；黄酒：250毫升；白糖：100克；酱油：150毫升；姜块：50克；葱结：50克；水：适量；生抽：50毫升', '（1）猪五花肉凉水洗干净，去掉皮上面的毛发\r\n（2）开水焯到九成熟\r\n（3）切成4乘以4的小方块\r\n（4）另取一砂锅，下面铺上香葱、姜片\r\n（5）肉皮向下，码放在香葱上面\r\n（6）加入白糖\r\n（7）加入绍酒\r\n（8）加入酱油，生抽就可以\r\n（9）基本不用怎么放水，先大火煮开\r\n（10）煮开之后小火\r\n（11）盖好盖子，微火焖两个小时\r\n（12）两个小时后把肉块翻过来肉皮朝上，加盖焖酥', 'dongporou.jpg');
INSERT INTO `cai` VALUES ('5', '无锡排骨', '无锡地方风味，名闻中外的旅游食品', '苏菜', '排骨：350克；西红柿：2个；葱：2大勺；姜：5片；蒜：1瓣；八角：2个；桂皮：1小块；生抽：2大勺；老抽：1大勺；番茄酱：1大勺半；黄酒：1小勺；白糖：1大勺半；香叶：3片；水：800克；植物油：适量', '（1）排骨剁成小块，用冷水泡20-30分钟去除血水捞出，锅中坐水烧开，放入排骨焯一下去腥和杂质，捞出备用\r\n（2）西红柿顶部切十字花刀，然后用开水烫一下剥皮后，切碎\r\n（3）炒锅烧热倒入4大勺油，油温5成热时放入葱姜蒜炒出香味，再倒入西红柿碎用小火炒至变软\r\n（4）放入番茄酱炒匀\r\n（5）倒入排骨继续炒约半分钟\r\n（6）倒入生抽、老抽\r\n（7）加大料、桂皮、香叶、料酒\r\n（8）放入冰糖\r\n（9）将调料和排骨炒匀\r\n（10）倒入开水，水量以漫过排骨为准\r\n（11）加盐，大火烧开，转小火炖约45分钟，至排骨软', 'wuxipaigu.jpg');
INSERT INTO `cai` VALUES ('6', '五香卷', '福建省的特色名吃', '闽菜', '猪肉：1500克；红葱头：500克；豆腐皮：13张；色拉油：适量；味精：半小勺；生抽：2勺；五香粉：1小包；地瓜粉：10克；白砂糖：1小勺', '（1）将肉洗净，切片\r\n（2）加入生抽、白糖拌匀，腌过3-4小时(过夜更入味)\r\n（3）红葱头剥去葱衣，洗净，切成薄碎片\r\n（4）腐皮用剪刀对开剪成两片\r\n（5）在腌好的肉里，放入切好的红葱头、味精、五香粉抓匀，慢慢加入适量的地瓜粉，使馅料成粘稠状\r\n（6）取些许地瓜粉，用生水打湿再冲进些许开水，调成浆糊状\r\n（7）把豆腐皮平放在案板上，取馅料放在豆腐皮一端，先将底部的腐皮卷起，再将两边的腐皮往中间折卷成条状卷\r\n（8）卷到剩下一小部分腐皮时，在未卷起的腐皮涂上少许面糊，粘牢便成五香卷生坯\r\n（9）油锅放', 'wuxiangjuan.jpg');
INSERT INTO `cai` VALUES ('7', '剁椒鱼头', '色香味俱全，适合家宴和请客用', '湘菜', '鱼头：1个；料酒：15克；红剁椒：50克；豆瓣酱：30克；豆豉：15克；葱段：30克；葱花：20克；姜片：20克；盐：2克', '（1）用少许盐和料酒将芋头腌制5分钟\r\n（2）锅中打入红剁椒、豆瓣酱、豆豉炒香，盛入碗中备用\r\n（3）碗底铺上姜片和葱段，将鱼头盖上\r\n（4）将炒好的剁椒酱均匀铺在鱼头上\r\n（5）移入蒸锅，沸水煮8分钟\r\n（6）撒上葱花，出锅', 'duojiaoyutou.jpg');
INSERT INTO `cai` VALUES ('8', '肥西老母鸡汤', '当地有方言：从肥东到肥西，买了一只老母鸡', '徽菜', '鸡肉：1只；食盐：4克；水：适量', '（1）鸡掏去内脏后冲洗洗净并沥干水分；用约4克的盐抹遍鸡的表面并稍作按摩一会儿（注意抹盐的时候不要抹到里面的肉，只限鸡皮部分就好），然后入冰箱冷藏约20～30分钟\r\n（2）从冰箱取出后加入和鸡齐平的冷水(约1250克)\r\n（3）放入已上汽的蒸锅中蒸煮；约30分钟后开锅加入秘制调料(蚕豆辣酱+葱姜蒜等和少量盐调味），然后盖上锅盖继续再蒸20分钟左右，原汁原味的肥西老母鸡汤制作完毕', 'feixilaomujitang.jpg');
INSERT INTO `cai` VALUES ('9', '麻婆豆腐', '四川省传统名菜之一', '川菜', '豆腐、里脊肉  豆瓣酱、姜蒜、花椒面', '1.豆腐切小块、里脊肉切末备用  将豆腐放入水中加盐淖去豆腥味，肉末加入少许豆粉腌制  2.锅中加食用油，倒入肉末翻炒到酥  3.加入姜、蒜、豆瓣酱炒出香味  4.锅中倒入料酒、酱油、适量清水烧开后下豆腐  5.倒入调好的淀粉（勾芡），待汁液浓缩吸收后装盘，撒上花椒面和葱花，即可食用了', 'chuancai_mapodoufu.jpg');
INSERT INTO `cai` VALUES ('10', '水煮肉片', '一道地方新创名菜，起源于自贡，发扬于西南，属于川菜中著名的家常菜。', ' 川菜', '五花肉1000克，白菜半棵，木耳几朵，郫县豆瓣酱50克，辣椒50克，花椒20克，八瓣1个，姜一块，蒜半头，葱半根，胡椒粉10克，全兴大曲酒1勺，骨汤1碗，盐适量', '1、热油爆香郫县豆瓣酱、辣椒、花椒、八瓣、姜蒜，得到香辣红油。取出一些煸香的辣椒花椒备用。  2、另取一锅，用刚才1/3的香辣红油炒下白菜。  3、几分钟后，倒入大碗里。  4、用2/3的香辣红油，加入骨汤、木耳煮沸。  5、加入肉片。  6、沸腾后，淋白酒，加胡椒粉、盐调味。  7、全部倒入垫了白菜底的盆中，撒些葱末。 最后起锅烧油到冒烟。把第一次煸香的辣椒花椒洒在肉片上。把烧热的油，迅速倒在盆中，满钵飘香的水煮肉片就做好了。', 'shuizhuroupian.jpg');
INSERT INTO `cai` VALUES ('11', '大煮干丝', '又称鸡汁煮干丝，传统名菜，属淮扬菜系', '苏菜', '厚百叶　2张，姜丝　适量，海米　2大匙，木耳　1朵，香菜　1棵，鸡清汤　适量，盐　适量，食用油　适量', '1.木耳与海米分别用水泡1小时取出清洗，泡海米的水用纱布滤去杂质留用。厚百叶与木耳切细丝，香菜切末。 2.锅内放油，将百叶稍翻炒一下，加入姜丝、海米、木耳、鸡汤、泡海米的水、盐，煮开后转小火炖15－20分钟，洒入香菜末出锅。', 'sucai_dazhugansi.jpg');
INSERT INTO `cai` VALUES ('12', '猪肉粉丝汤', '外皮光滑，内如丝网，细软绵实，富有弹性', '苏菜', '猪肉丝200克（肥瘦各半），干粉丝100克，油豆腐150克，葱花50克，杏仁50克，香油10毫升，盐5克，胡椒3克，葱1棵', '1.粉丝先用热水泡开，捞出后沥干水分；猪肉丝放入滚水中氽烫变色，捞出洗净；杏仁洗净后泡水；油豆腐洗净对半切开；葱切花。 2.杏仁、猪肉丝、油豆腐加入足量清水煮开后，加入粉丝煮约5分钟，撤上葱花。 3.最后加盐、胡椒调味，淋上香油，撒上葱花即成', 'sucai_zhuroufensitang.jpg');
INSERT INTO `cai` VALUES ('14', '农家小炒肉', '属于湘菜或川菜，是一道家常菜', '湘菜', '主料 五花肉	适量、线椒	适量、小米椒	适量 辅料 盐		1勺、食用油	适量、蒜	适量、豆豉	5克、酱油	15克、生抽	10克、白糖	3克', '1. 五花肉一块去皮切成片。线椒、小米椒切滚刀条或斜条，根据你的喜欢来决定，我切的是斜条。  2. 干锅小火煸炒线椒，把水分炒没了，放一勺盐，炒至虎皮即可捞出备用。  3. 锅中热油，放五花肉煸炒，加蒜和豆豉5克至出油。  4. 加线椒翻炒，加酱油15克和生抽10克，放入白糖3克搅匀', 'xiangcai_xiaochaorou.jpg');
INSERT INTO `cai` VALUES ('15', '豉椒蒸排骨', '豆豉辣椒蒸排骨是很多人都喜欢的口味', '粤菜', '猪肋排骨，豆豉少许，生姜，干红椒，葱，生抽，料酒，糖，淀粉', '1.豆豉过一下水洗去表面盐分，用刀剁碎．生姜切成末，干红椒切短，葱切葱花． 2.排骨洗净控干水后，加碎豆豉／姜末／生抽／糖／料酒／淀粉适量，拌匀后．静置腌制至少两小时（我有时候晚上准备次日的就腌制过夜，放冰箱加盖即可）。 3.蒸笼水滚后排骨连容器入屉．大火蒸20分钟后，洒上干红椒继续蒸10分钟关火．（如果要辣一些就把辣椒混合在腌料中）。 4.出锅洒上葱花即可．肉质鲜嫩，豉香诱人。', 'yuecai_douzhizhengpaigu.jpg');
INSERT INTO `cai` VALUES ('16', '广东油鸡', '是一道以鸡肉为主要食材的美味菜肴,口感油而不腻', '粤菜', '鸡腿2只，水1/2杯，广东油鸡淋酱13杯', '(1)将鸡腿放入开水中汆烫一下去血水，然后沥干备用。  (2)将广东油鸡淋酱放入锅中煮开，然后将鸡腿放入，加1/2杯水，盖上锅盖煮3分钟即可熄火。让鸡腿再浸泡25分钟，即可取出放凉。  (3)香油涂在放凉的鸡腿上，然后切块排盘，再淋上少许卤汁即可上桌。', 'yuecai_guandongyouji.jpg');
INSERT INTO `cai` VALUES ('20', '叫花鸡', '又称常熟叫化鸡、煨鸡，是江苏常熟地区传统名菜', '浙菜', '童子鸡一只、冬笋片适量、冬菇适量、虾仁适量、五花肉适量、猪网油适量、马莲草适量、黄泥适量、鲜荷叶适量、烘焙纸适量', '童子鸡洗净，斩去指甲、尾部虾仁、五花肉丁、笋片、八角、丁香、冬菇块，加入生抽、白糖拌成馅料将馅料填入鸡腹黄土泥加适量水合成团包裹上荷叶用马莲草系紧，再包上一层烘焙用将和好的黄泥裹在鸡上，烤盘垫上油纸放入烤箱，180度中下层、烘焙1.5-2小时即可熟时取出敲掉泥去荷叶，淋上香油', 'zhecai_jiaohuaji.jpg');
INSERT INTO `cai` VALUES ('21', '山东狮子头', '这锅的卤狮子头,咸香软烂，十分下饭', '鲁菜', '白馒头400公克，葱末25公克，姜末15公克，蒜末20公克，盐6公克，细砂糖25公克，酱油35公克，香油20公克，水200公克，冰糖30公克，八角2粒', '1.白馒头先撕碎用水泡软备用。  2.将作法1的白馒头及所有肉馅材料B的材料搅拌均匀至呈黏稠胶状，放入冰箱冷藏。  3.冷藏过后的肉馅直接用手搓成圆扁状的狮子头。  4.取一平底锅，，热油锅，再将狮子头逐一放入，以小火至中火煎至两面都金黄色时即可取出。  5.将卤汁材料一同放入锅中煮滚，再将作法4的狮子头放入卤汁中卤约35分钟即可。', 'lucai_shandongshizitou.jpg');
INSERT INTO `cai` VALUES ('22', '山东焖烧鸡', '八角是精华所在，米酒可以用料酒替代', '鲁菜', '鸡腿肉，姜，八角，生抽，米酒，（葱），干辣椒', '1、鸡腿肉切小块儿备用。  2、热锅下油，用五六个姜片炝锅，姜片变金黄色后加入鸡腿肉拌炒。  3、至鸡皮开始紧缩的时候加几个八角，再加两汤匙米酒、两到三汤匙生抽、少许糖，可以吃辣的加些干辣椒，然后转小火，盖盖子开始焖烧。期间可以开盖略搅拌，再焖5分钟即成。', 'lucai_shandongmenshaoji.jpg');
INSERT INTO `cai` VALUES ('23', '泉州醋肉', ' 醋肉是泉州一道极具名气人气的地道闽南小吃', '闽菜', '材料：猪肉里脊 500g、地瓜粉 200g、白砂糖 4勺、盐 2勺 酱油 1勺、老陈醋 2勺、五香粉 2勺', '1. 对于闽南的醋肉来说，使用的肉可以是里脊肉也可以是五花肉我所用的是一半里脊一半前腿肉其实要做这个最好是肉中带点油花炸出来最好吃 肉洗洗挤去水2肉切薄长条3肉下五香粉、白砂糖、盐、酱油、老陈醋腌制2小时4腌制2小时后倒掉腌制出的水分5放入地瓜粉用手搅拌均匀6呈半干状无水分，请根据实际情况油热大概7分开始下锅炸，炸的时候要注意稍后才翻动', 'yuecai_guandongyouji.jpg');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `account` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `employment` varchar(255) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `problem` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('13', null, '000001', '123456', null, null, null, null);
INSERT INTO `user` VALUES ('14', '张三', '000002', '123456', null, null, null, null);
INSERT INTO `user` VALUES ('15', '李四', '000004', '123456', null, null, null, null);
INSERT INTO `user` VALUES ('16', '王五', '000005', '123456', null, null, null, null);
INSERT INTO `user` VALUES ('17', 'root', 'root123456', '123456', null, null, null, null);
