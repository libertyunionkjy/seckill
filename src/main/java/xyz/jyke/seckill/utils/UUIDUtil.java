package xyz.jyke.seckill.utils;

import java.util.UUID;

public class UUIDUtil {
      public static String uuid() {
         return UUID.randomUUID().toString().replace("-", "");
} }