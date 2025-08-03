package com.blink.academy.film.support.stream.ts;

import com.blink.academy.film.support.stream.ts.PatPacket;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes.dex */
class TSTableData {
    public List<PatPacket.Program> mProgramList;
    private int currentTransportStreamID = -1;
    private final HashMap<Integer, Integer> PATmap = new HashMap<>();
    private final HashMap<Integer, Integer> PMTmap = new HashMap<>();
    private final HashMap<Integer, Integer> ESmap = new HashMap<>();
    private final HashSet<Integer> PMTset = new HashSet<>();
    private final HashMap<Integer, String> programNameMap = new HashMap<>();
    private final HashMap<Integer, Integer> programTransportStreamMap = new HashMap<>();
    private final HashMap<Integer, String> providerNameMap = new HashMap<>();
    private final HashMap<Integer, Integer> programTypeMap = new HashMap<>();
    private final HashMap<Integer, Boolean> programFreeCAModeMap = new HashMap<>();
    private String networkName = "";
    private final HashMap<Integer, Integer> transportStreamMap = new HashMap<>();
    private final HashSet<Integer> transportStreamSet = new HashSet<>();
    private HashMap<Integer, Integer> programMap = new HashMap<>();
}
