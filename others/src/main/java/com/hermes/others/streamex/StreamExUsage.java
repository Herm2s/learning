package com.hermes.others.streamex;

import com.google.common.collect.Lists;
import one.util.streamex.DoubleStreamEx;
import one.util.streamex.EntryStream;
import one.util.streamex.IntStreamEx;
import one.util.streamex.StreamEx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * @author herm2s
 * @since 2023/2/4 1:19
 */
public class StreamExUsage {

    public static void main(String[] args) {
        User xiaoming = new User(1, "小明");
        User xiaohong = new User(1, "小红");
        ArrayList<User> users = Lists.newArrayList(xiaoming, xiaohong);

        // 简化集合操作
        List<String> userNames = StreamEx.of(users)
                .map(User::getName)
                .toList();
        System.out.println(userNames);

        // 快速分组
        Map<Role, List<User>> role2Users = StreamEx.of(users)
                .groupingBy(User::getRole);
        System.out.println(role2Users);

        // 简化字符串连接
        String joining = StreamEx.of(1, 2, 3).joining(",", "[", "]");
        System.out.println(joining);

        // 快速筛选class
        List<Object> usersAndRoles = Arrays.asList(xiaoming, new Role());
        List<User> roles = StreamEx.of(usersAndRoles)
                .select(User.class)
                .toList();
        System.out.println(roles);

        // 头尾添加
        List<String> appendedUsers = StreamEx.of(users)
                .map(User::getName)
                .prepend("(none)")
                .append("LAST")
                .toList();
        System.out.println(appendedUsers);

        // 快速过滤空属性
        for (String line : StreamEx.of(users).map(User::getName).nonNull()) {
            System.out.println(line);
        }

        // 基本类型快速类型转换
        short[] src = {1, 2, 3};
        int[] output = IntStreamEx.of(src)
                .map(x -> x * 5)
                .toArray();
        System.out.println(Arrays.toString(output));

        // 对每两个相邻元素进行操作
        double[] numbers = new double[]{1.1, 2.2, 3.0};
        double[] doubles = DoubleStreamEx.of(numbers)
                .pairMap((a, b) -> b - a)
                .toArray();
        System.out.println(Arrays.toString(doubles));

        // 筛选value符合条件的key
        Map<String, Role> nameToRole = new HashMap<>();
        nameToRole.put("first", new Role());
        nameToRole.put("second", null);
        Set<String> nonNullRoles = StreamEx.ofKeys(nameToRole, Objects::nonNull)
                .toSet();
        System.out.println(nonNullRoles);

        // 反转key和value
        Map<User, List<Role>> users2roles = EntryStream.of(role2Users)
                .flatMapValues(List::stream)
                .invert()
                .grouping();
        System.out.println(users2roles);

        // 改变key和value的类型
        Map<String, String> mapToString = EntryStream.of(users2roles)
                .mapKeys(String::valueOf)
                .mapValues(String::valueOf)
                .toMap();
        System.out.println(mapToString);
    }
}
