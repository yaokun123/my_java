package com.designmode.q_bridge.v2;

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

// 如果礼物分为温柔的礼物和狂野的礼物
// WarmGift WildGift
// 这时Flower和Book应该分为
// WarmFlower WildFlower
// WarmBook WildBook