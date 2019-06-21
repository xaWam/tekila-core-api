/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jaravir.tekila.module.service;

/**
 * @author sajabrayilov, Musa.
 *
 * important information is that -> setting_type on ServiceSettings is ordinal position of enum element  it start from 0 ->...
 */
public enum ServiceSettingType {
    USERNAME,
    PASSWORD,
    BROADBAND_SWITCH,
    BROADBAND_SWITCH_PORT,
    TV_EQUIPMENT,
    MSISDN,
    BROADBAND_SWITCH_IP,
    BROADBAND_SWITCH_SLOT,
    MAC_ADDRESS,
    DEALER,
    ATS_PORT,
    INFO,
    IP_ADDRESS,
    SERVICE_TYPE, //PPPoE or IPoE
    ZONE,
    SIP,
    SIP_OLD_OUTG_STATUS
}