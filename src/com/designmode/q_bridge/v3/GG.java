package com.designmode.q_bridge.v3;

public class GG {
    public void chase(MM mm){
        Gift g = new Book();
        give(mm,g);
    }
    public void give(MM mm, Gift g){}
}

class MM{
    String name;
}

abstract class Gift{}

class WarmGift extends Gift{}

class WildGift extends Gift{}


class Book extends Gift{}

class Flower extends Gift{}
class WarmFlower extends Flower{//WarmGift
//使用继承，容易产生类爆炸

}

// 如果礼物分为温柔的礼物和狂野的礼物
// WarmGift WildGift
// 这时Flower和Book应该分为
// WarmFlower WildFlower
// WarmBook WildBook

/**
 * 使用侨接模式
 * 分离抽象与具体实现，让他们可以独自发展
 * Gift->WarmGift ColdFift WildGift
 * GiftImpl->Flower Ring Car
 */