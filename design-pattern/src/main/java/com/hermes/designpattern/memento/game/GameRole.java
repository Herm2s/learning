package com.hermes.designpattern.memento.game;

import lombok.Data;

/**
 * @author liu.zongbin
 * @since 2022/8/27
 */
@Data
public class GameRole {

    private int vit;

    private int def;

    /**
     * 保存状态到备忘录
     */
    public Memento createMemento() {
        return new Memento(vit, def);
    }

    /**
     * 从备忘录对象恢复状态
     */
    public void recoverGameRoleFromMemento(Memento memento) {
        this.vit = memento.getVit();
        this.def = memento.getDef();
    }

    /**
     * 显示当前状态
     */
    public void display() {
        System.out.println("角色当前的攻击力：" + this.vit + " 防御力：" + this.def);
    }
}
