package com.uohzey.constellation;

import com.uohzey.constellation.R;

import android.os.Bundle;
import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends Activity {
	private ImageView resultImg;
	private TextView resultTv;

	private int getAstro(int month, int day) {
		int[] starArr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		int[] DayArr = { 22, 20, 19, 21, 21, 21, 22, 23, 23, 23, 23, 22 }; // 两个星座分割日
		int index = month;
		// 所查询日期在分割日之前，索引-1，否则不
		if (day < DayArr[month - 1]) {
			index = index - 1;
		}
		// 返回索引指向的星座string
		return starArr[index%12];
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		resultImg = (ImageView) findViewById(R.id.result_img);
		resultTv = (TextView) findViewById(R.id.result_tv);
		// 得到intent对象
		Intent intent = getIntent();
		int month = intent.getIntExtra("MON", -1);
		Log.d("ResultActivity", month+""       );
		int day = intent.getIntExtra("DAY", -1);
		if (getAstro(month, day) == 1) {
			resultImg.setImageResource(R.drawable.capricorn);
			resultTv.setText("摩羯座是象征着冬天开始的星座，也是善良与邪恶混为一体的一个星座。冬天把“绝对意识”毫无保留地带给了摩羯座出生的人。摩羯座的人，尤其当有几个行星同时处于你的星座时，你将是一个具有现实主义思想的人。");
		}
		else if (getAstro(month, day) == 2) {
			resultImg.setImageResource(R.drawable.aquarius);
			resultTv.setText("水瓶座（Aquarius），日期为1月20日—2月18日，黄道星座之第十一宫，在摩羯座之东，双鱼座之西。水瓶座的人善于重新组织自己的精神生活，是新思想的开拓者。追求属于自己独一无二的生活方式，是水瓶星座的生活态度，他们独特的见解往往是最前卫而正确的思想，但是他们常常不会显露出来他们超高的智商，比较谦虚，旁人往往会低估他们的智商，水瓶座是十二星座当中智商最高的星座。 [1]  由于他们对自己独特高超的见解很坚定不移，往往被无法理解的人认为是固执。");
		}
		if (getAstro(month, day) == 3) {
			resultImg.setImageResource(R.drawable.pisces);
			resultTv.setText("双鱼座（Pisces）的出生日期为2月19日—3月20日，黄道星座之第十二宫，位于水瓶座之东，白羊座之西。守护星是木星、海王星。代表色是海蓝色。");
		}
		if (getAstro(month, day) == 4) {
			resultImg.setImageResource(R.drawable.aries);
			resultTv.setText("白羊座（Aries），黄道十二星座之第一宫，位于双鱼座之东，金牛座之西，出生日期为阳历3月21日~4月20日。白羊座就像小孩子一样，直率、热情、冲动，但也十分的自我为中心和孩子气。");
		}
		if (getAstro(month, day) == 5) {
			resultImg.setImageResource(R.drawable.taurus);
			resultTv.setText("金牛座（Taurus），出生日期为阳历4月21日~5月20日，位于白羊座之东，是黄道十二宫的第二宫。是个很保守的星座，喜欢稳定，不爱变动。名副其实的现实主义者，具有持之以恒的精神，适合从事需要顽强毅力和付出长期艰苦努力的工作。思想和情感的变化比较缓慢。");
		}
		if (getAstro(month, day) == 6) {
			resultImg.setImageResource(R.drawable.gemini);
			resultTv.setText("双子座（Gemini），出生日期为5月21日~6月21日，是黄道十二宫里的第三宫，代表了善变、沟通。双子座的人喜爱变化。盎然的春意表现在双子座的人性格上的主要特征是思维善变，无拘无束，对外界包罗万象的事物的永无休止的好奇心，可以说是机敏、好动又不安的星座。");
		}
		if (getAstro(month, day) == 7) {
			resultImg.setImageResource(R.drawable.cancer);
			resultTv.setText("巨蟹座是夏天开始的第一个星座，也是十二星座里最暗的一个星座，象征人类内在潜能和灵魂，出生日期为6月22日至7月22日（西历）。巨蟹座位于双子座之东，狮子座之西。巨蟹座的占星符号象征两个蟹钳。");
		}
		if (getAstro(month, day) == 8) {
			resultImg.setImageResource(R.drawable.leo);
			resultTv.setText("狮子座（Leo），黄道十二宫之第五宫，出生日期为7月23日~8月22日，位于巨蟹座之东，处女座之西。狮子宫的符号为♌，代表狮子的头和身体及尾巴。 [1]  狮子座是由太阳神阿波罗所管理，所以本他身上处处显露阳光、热情、自信、大方都是他的特质。而且天生的领导才能令他喜欢指挥别人和有强大的组织能力，不过过份自信变成自大，加上固执的性格，反应夸张，有时令人不知如何与他相处。狮子座有着宏伟的理想，总想靠自己的努力成为人上人，你向往高高在上的优越感，也期待被仰慕被崇拜的感觉，有点儿自信有点儿自大。狮子男的大男人气息很重，爱面子，狮子女热情阳光，对朋友讲义气。喜欢成为焦点人物的狮子座，都有脆弱之时；因为他们太在乎别人对他的看法，往往因此而不快乐；不肯认输的个性，也是令自己不愉快的泉源。狮子座的女性更加可怜，她们是最怕老、怕寂寞、怕不被别人尊重的星座，为了要打击这些心魔，她们会不惜任何方法去改变它们。");
		}
		if (getAstro(month, day) == 9) {
			resultImg.setImageResource(R.drawable.virgo);
			resultTv.setText("室女座（拉丁语：Virgo，天文符号：♍），是最大的黄道带星座，面积1294.43平方度，占全天面积的3.318%，在全天88个星座中，面积排行第二位，仅次于长蛇座。室女座中亮于5.5等的恒星有58颗，最亮星为角宿一（室女座α星）视星等为0.98。每年4月11日子夜室女座中心经过上中天。现在的秋分点位于右执法（室女座β）附近。室女座也叫处女座。日本 室女、处女，拉丁语Virgo，都代表室女座。");
		}
		if (getAstro(month, day) == 10) {
			resultImg.setImageResource(R.drawable.libra);
			resultTv.setText("天秤座，也译作天平座Libra，出生日期为9月23日—10月23日。位于处女座之东，天蝎座之西，是黄道十二宫的第七宫。天秤座是象征着秋天来临的星座，秋意表现在天秤座的人身上是对意气相投的特殊嗅觉。 [1]  为人热情，优雅，善于表达");
		}
		if (getAstro(month, day) == 11) {
			resultImg.setImageResource(R.drawable.scorpio);
			resultTv.setText("天蝎座（Scorpio），是十二星座之黄道第八宫，位于天秤座之东，射手座之西。出生日期为10月24日-11月22日。这一星座的人对互不相同的和互不相融的事物有特殊的兴趣，也喜欢探究事物的本质并加以区别。");
		}
		if (getAstro(month, day) == 12) {
			resultImg.setImageResource(R.drawable.sagittarius);
			resultTv.setText("射手座，出生时间是11月23日~12月21日，黄道十二宫之第九宫，位于天蝎座之东，摩羯座之西。 [1-2]  射手座是象征着冬季来临的星座，射手座就像那只搭在弦上的箭，他们朝着人生目标不断迈进。射手座的人为人心胸开阔，冷静谦和，宽厚，重情义，注重社会责任和文化修养。");
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.result, menu);
		return true;
	}

}
