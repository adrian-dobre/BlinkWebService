# Blink For Home API Documentation

## POST https://rest-prod.immedia-semi.com/api/v4/account/login

#### Request Body
 ```
{
   "app_version": "6.0.10 (8280) #881c8812",
   "device_identifier": "iPhone12,3",
   "password": "dasdasdas",
   "os_version": "13.5",
   "client_type": "ios",
   "unique_id": "DDA09CEB-3B0B-42D0-AA67-3424542345321",
   "notification_key": "d8bsefsv7dtcbst3bnwxesevrsv6cedsvx33s",
   "email": "some@email.com",
   "client_name": "iPhone"
} 
```

#### Response Headers
 - content-type: application/json

#### Response Body
 ```
{
   "account": {
      "id": 97998,
      "verification_required": false,
      "new_account": false
   },
   "client": {
      "id": 213135,
      "verification_required": true
   },
   "authtoken": {
      "authtoken": "asdytas7d7asda3rdsda32",
      "message": "auth"
   },
   "region": {
      "tier": "e001",
      "description": "Europe",
      "code": "eu"
   },
   "lockout_time_remaining": 0,
   "force_password_reset": false,
   "allow_pin_resend_seconds": 60
} 
```



## POST https://rest-{region.tier}.immedia-semi.com/api/v4/account/{accountId}/client/{clientId}/pin/verify

#### Request Headers
 - token-auth: asdytas7d7asda3rdsda32

#### Request Body
 ```
{
   "pin": "423423"
} 
```

#### Response Headers
 - content-type: application/json

#### Response Body
 ```
{
   "valid": true,
   "require_new_pin": false,
   "message": "Client has been successfully verified",
   "code": 1626
} 
```



## GET https://rest-{region.tier}.immedia-semi.com/api/v3/accounts/{accountId}/homescreen

#### Request Headers
 - token-auth: asdytas7d7asda3rdsda32

#### Response Headers
 - content-type: application/json

#### Response Body
 ```
{
   "account": {
      "id": 97998,
      "email_verified": true,
      "email_verification_required": true
   },
   "networks": [
      {
         "id": 116468,
         "created_at": "2020-02-09T20:01:14+00:00",
         "updated_at": "2020-06-01T15:36:35+00:00",
         "name": "Home",
         "time_zone": "Europe/Bucharest",
         "dst": true,
         "armed": false,
         "lv_save": false
      }
   ],
   "sync_modules": [
      {
         "id": 207919,
         "created_at": "2020-02-13T18:51:54+00:00",
         "updated_at": "2020-06-01T00:01:26+00:00",
         "onboarded": true,
         "status": "online",
         "name": "My Blink Sync Module",
         "serial": "201561627",
         "fw_version": "2.13.18",
         "last_hb": "2020-06-01T15:37:55+00:00",
         "wifi_strength": 5,
         "network_id": 116468,
         "enable_temp_alerts": true
      }
   ],
   "cameras": [
      {
         "id": 259335,
         "created_at": "2020-02-13T10:38:20+00:00",
         "updated_at": "2020-06-01T15:36:37+00:00",
         "name": "hallway",
         "serial": "831350271",
         "fw_version": "7.96",
         "type": "xt2",
         "enabled": true,
         "thumbnail": "/media/e001/account/{accountId}/network/{networkId}/camera/{cameraId}/thumbnail/fw_7.96__bErKuR9D_2020_06_01__15_36PM",
         "status": "done",
         "battery": "ok",
         "usage_rate": false,
         "network_id": 116468,
         "issues": [],
         "signals": {
            "lfr": 5,
            "wifi": 5,
            "temp": 73,
            "battery": 3
         }
      }
   ],
   "sirens": [],
   "chimes": [],
   "video_stats": {
      "storage": 8,
      "auto_delete_days": 30
   },
   "doorbell_buttons": [],
   "owls": [],
   "app_updates": {
      "message": "OK",
      "code": 103,
      "update_available": false,
      "update_required": false
   },
   "device_limits": {
      "total_devices": 20,
      "owl": 10,
      "camera": 10,
      "siren": 5,
      "doorbell_button": 2,
      "chime": 5
   },
   "whats_new": {
      "updated_at": 20200416,
      "url": "https://blinkforhome.com/blogs/updates"
   }
} 
```



## GET https://rest-{region.tier}.immedia-semi.com/api/v1/accounts/{accountId}/clients/{clientId}/options

#### Request Headers
 - token-auth: asdytas7d7asda3rdsda32

#### Response Headers
 - content-type: application/json

#### Response Body
 ```
{
   "options": "eyJuZXR3b3JrX29yZGVyIjpbMTE2NDY4XSwia2V5cyI6W1siY2xpZW50Lm9wdGlvbnMuYXJtX2NhbGxvdXRfc3RhdGUiLCJOMiJdLFsiY2xpZW50Lm9wdGlvbnMuY2FtZXJhX2NlbGxfY2FsbG91dF9zdGF0ZSIsIk4yIl0sWyJjbGllbnQub3B0aW9ucy5zaG93X3R1Y3Nvbl90dXRvcmlhbF9zdGF0ZSIsIk4xIl0sWyJob21lc2NyZWVuLndoYXRzX25ld19sYXN0X3Nob3dlZF9hdCIsIk4yMDIwMDQxNiJdLFsiY2xpZW50Lm9wdGlvbnMuc2hvd19ob21lc2NyZWVuX3R1dG9yaWFsX3N0YXRlIiwiTjEiXSxbImNsaWVudC5vcHRpb25zLnNob3dfYWRkX2RldmljZV90dXRvcmlhbF9zdGF0ZSIsIk4xIl1dLCJzY2hlbWEiOjEsImNhbWVyYV9vcmRlciI6eyIxMTY0NjgiOlsyNTkzMzVdfX0="
} 
```



## GET https://rest-{region.tier}.immedia-semi.com/api/v1/accounts/{accountId}/media/changed

#### Request Headers
 - token-auth: asdytas7d7asda3rdsda32

#### Request Query
 - since: 2020-06-01T15:36:56+0000
 - page: 1

#### Response Headers
 - content-type: application/json

#### Response Body
 ```
{
   "limit": 25,
   "purge_id": 315559393,
   "refresh_count": 0,
   "media": [
      {
         "id": 310782995,
         "created_at": "2020-05-21T20:50:59+00:00",
         "updated_at": "2020-06-01T15:37:53+00:00",
         "deleted": true,
         "device": "camera",
         "device_id": 259335,
         "device_name": "hallway",
         "network_id": 116468,
         "network_name": "Home",
         "type": "video",
         "source": "pir",
         "watched": true,
         "partial": false,
         "thumbnail": "/api/v2/accounts/{accountId}/media/thumb/310782995",
         "media": "/api/v2/accounts/{accountId}/media/clip/310782995.mp4",
         "additional_devices": [],
         "time_zone": "Europe/Bucharest"
      }
   ]
} 
```



## GET https://rest-{region.tier}.immedia-semi.com/api/v1/account/options

#### Request Headers
 - token-auth: asdytas7d7asda3rdsda32

#### Response Headers
 - content-type: application/json

#### Response Body
 ```
{
   "media_table_enabled": true,
   "speaker_volume_enabled": true,
   "advanced_motion_regions": {
      "cam_259335": [
         4095,
         4095,
         4095,
         4095,
         4095,
         4095,
         4095,
         4095,
         4095,
         4095,
         4095,
         4095,
         4095,
         4095,
         4095,
         4095,
         4095,
         4095,
         4095,
         4095,
         4095,
         4095,
         4095,
         4095,
         4095
      ]
   },
   "owl_app_enabled": true,
   "legacy_account_mini": true
} 
```



## GET https://rest-{region.tier}.immedia-semi.com/api/v1/accounts/{accountId}/notifications/configuration

#### Request Headers
 - token-auth: asdytas7d7asda3rdsda32

#### Response Headers
 - content-type: application/json

#### Response Body
 ```
{
   "notifications": {
      "low_battery": true,
      "camera_offline": true,
      "camera_usage": true,
      "scheduling": true,
      "motion": true,
      "sync_module_offline": true,
      "temperature": true,
      "doorbell": true,
      "wifi": true,
      "lfr": true,
      "bandwidth": true,
      "battery_dead": true
   }
} 
```



## GET https://rest-{region.tier}.immedia-semi.com/api/v1/networks/{networkId}/programs

#### Request Headers
 - token-auth: asdytas7d7asda3rdsda32

#### Response Headers
 - content-type: application/json

#### Response Body
 ```
[
   {
      "id": 26830,
      "network_id": 116468,
      "status": "enabled",
      "name": "Schedule for Home",
      "schedule": [
         {
            "dow": [
               "sun",
               "mon",
               "tue",
               "wed",
               "thu",
               "fri",
               "sat"
            ],
            "devices": [],
            "time": "2020-02-14 21:00:00 +0000",
            "action": "arm"
         },
         {
            "dow": [
               "sun",
               "mon",
               "tue",
               "wed",
               "thu",
               "fri",
               "sat"
            ],
            "devices": [],
            "time": "2020-02-14 05:00:00 +0000",
            "action": "disarm"
         }
      ],
      "format": "v1"
   }
] 
```



## GET https://rest-{region.tier}.immedia-semi.com/media/e001/account/{accountId}/network/{networkId}/camera/{cameraId}/thumbnail/fw_7.96__3UCjj1NM_2020_06_01__14_01PM.jpg

#### Request Headers
 - token-auth: asdytas7d7asda3rdsda32

#### Response Headers
 - content-type: image/jpeg



## GET https://rest-{region.tier}.immedia-semi.com/network/{networkId}/camera/{cameraId}/config

#### Request Headers
 - token-auth: asdytas7d7asda3rdsda32

#### Response Headers
 - content-type: application/json

#### Response Body
 ```
{
   "camera": [
      {
         "id": 259335,
         "created_at": "2020-02-13T10:38:20+00:00",
         "updated_at": "2020-06-01T15:36:37+00:00",
         "deleted_at": null,
         "serial": "831350271",
         "camera_key": "",
         "fw_version": "7.96",
         "mac_address": "f4:b8:5e:8d:65:ff",
         "ip_address": null,
         "thumbnail": "/media/e001/account/{accountId}/network/{networkId}/camera/{cameraId}/thumbnail/fw_7.96__bErKuR9D_2020_06_01__15_36PM",
         "name": "hallway",
         "liveview_enabled": "off",
         "siren_enable": false,
         "siren_volume": null,
         "onboarded": true,
         "unit_number": 1,
         "motion_sensitivity": 6,
         "enabled": true,
         "alert_tone_enable": true,
         "alert_tone_volume": 0,
         "alert_repeat": "off",
         "alert_interval": 10,
         "video_length": 30,
         "temp_alarm_enable": false,
         "temp_interval": 1,
         "temp_adjust": -4,
         "temp_min": 39,
         "temp_max": 90,
         "temp_hysteresis": null,
         "illuminator_enable": 2,
         "illuminator_duration": 1,
         "illuminator_intensity": 4,
         "battery_alarm_enable": false,
         "battery_voltage_interval": 0,
         "battery_voltage_threshold": 512,
         "battery_voltage_hysteresis": 512,
         "last_battery_alert": null,
         "battery_alert_count": 0,
         "lfr_sync_interval": 7,
         "video_50_60hz": "freq_60hz",
         "invert_image": false,
         "flip_image": false,
         "record_audio_enable": true,
         "clip_rate": 411,
         "liveview_rate": 0,
         "max_resolution": "r1080",
         "auto_test": false,
         "wifi_timeout": 30,
         "retry_count": 0,
         "status": "done",
         "wifi_strength": -51,
         "lfr_strength": -56,
         "temperature": 77,
         "battery_voltage": 155,
         "a1": false,
         "last_temp_alert": null,
         "temp_alert_count": 0,
         "last_wifi_alert": null,
         "wifi_alert_count": 0,
         "last_lfr_alert": null,
         "lfr_alert_count": 0,
         "last_offline_alert": null,
         "offline_alert_count": 0,
         "temp_alert_state": "in_range",
         "battery_state": "ok",
         "battery_check_time": "2020-06-01T15:36:37+00:00",
         "motion_regions": 33554431,
         "mfg_main_type": "EWM",
         "mfg_main_range": 1912033705,
         "mfg_mez_type": "XWZ",
         "mfg_mez_range": 1911337798,
         "type": "xt2",
         "account_id": 97998,
         "network_id": 116468,
         "sync_module_id": 207919,
         "account": 97998,
         "network": 116468,
         "camera_seq": 1,
         "last_connect": {
            "camera_id": 259335,
            "created_at": "2020-02-13T10:38:47+00:00",
            "updated_at": "2020-06-01T15:36:11+00:00",
            "wifi_strength": -52,
            "lfr_strength": -54,
            "battery_voltage": 155,
            "temperature": 77,
            "fw_version": "7.96",
            "fw_git_hash": "7.95_fixes:b3aec29",
            "mac": "f4:b8:5e:8d:65:ff",
            "ipv": "ipv4",
            "ip_address": "192.168.1.119",
            "error_codes": 0,
            "battery_alert_status": true,
            "temp_alert_status": false,
            "ac_power": false,
            "light_sensor_ch0": 173,
            "light_sensor_ch1": 63826,
            "light_sensor_data_valid": true,
            "light_sensor_data_new": true,
            "time_first_video": 0,
            "time_108_boot": 57143,
            "time_wlan_connect": 841308,
            "time_dhcp_lease": 1478270,
            "time_dns_resolve": 6375,
            "lfr_108_wakeups": 74,
            "total_108_wakeups": 299,
            "lfr_tb_wakeups": 65455,
            "total_tb_wakeups": 43520,
            "wifi_connect_failure_count": 0,
            "dhcp_failure_count": 0,
            "socket_failure_count": 7191,
            "dev_1": 1487070,
            "dev_2": 476,
            "dev_3": 458804,
            "unit_number": 1,
            "serial": "831350271",
            "lifetime_count": 0,
            "lifetime_duration": 0,
            "pir_rejections": 0,
            "sync_module_id": 207919,
            "network_id": 116468,
            "account_id": 97998
         },
         "motion_alert": true,
         "record_audio": true,
         "buzzer_on": true,
         "early_termination": true,
         "clip_bitrate": 411,
         "liveview_bitrate": 0,
         "motion_regions_compatible": true,
         "early_pir_compatible": false,
         "early_notification_compatible": true,
         "night_vision_exposure_compatible": false,
         "privacy_zones_compatible": false,
         "video_quality_support": [
            "saver",
            "standard",
            "best"
         ],
         "video_quality": "best",
         "early_notification": false,
         "night_vision_exposure": 1,
         "clip_max_length": 60,
         "early_termination_supported": true,
         "clip_warning_threshold": 15,
         "flip_video_compatible": false,
         "flip_video": false,
         "video_recording_enable": true,
         "video_recording_optional": false
      }
   ],
   "signals": {
      "lfr": 5,
      "wifi": 5,
      "updated_at": "2020-06-01T15:36:11+00:00",
      "temp": 73,
      "battery": 3,
      "battery_state": "ok"
   }
} 
```



## POST https://rest-{region.tier}.immedia-semi.com/api/v1/network/{networkId}/camera/{cameraId}/temp_alert_enable

#### Request Headers
 - token-auth: asdytas7d7asda3rdsda32

#### Response Headers
 - content-type: application/json

#### Response Body
 ```
{
   "message": "Camera temp alert successfully enabled",
   "code": 526
} 
```



## POST https://rest-{region.tier}.immedia-semi.com/api/v1/network/{networkId}/camera/{cameraId}/temp_alert_disable

#### Request Headers
 - token-auth: asdytas7d7asda3rdsda32

#### Response Headers
 - content-type: application/json

#### Response Body
 ```
{
   "message": "Camera temp alert successfully disabled",
   "code": 527
} 
```



## POST https://rest-{region.tier}.immedia-semi.com/api/v1/network/{networkId}/camera/{cameraId}/calibrate

#### Request Headers
 - token-auth: asdytas7d7asda3rdsda32

#### Request Body
 ```
{
   "temp_max": 90,
   "id": 259335,
   "current_temp": 73,
   "temp_min": 39,
   "network": 116468
} 
```

#### Response Headers
 - content-type: application/json

#### Response Body
 ```
{
   "id": 93856369,
   "created_at": "2020-06-01T15:35:21+00:00",
   "updated_at": "2020-06-01T15:35:21+00:00",
   "execute_time": "2020-06-01T15:35:21+00:00",
   "command": "temp_calibrate",
   "state_stage": "rest",
   "stage_rest": "2020-06-01T15:35:21+00:00",
   "stage_cs_db": null,
   "stage_cs_sent": null,
   "stage_sm": null,
   "stage_dev": null,
   "stage_is": null,
   "stage_lv": null,
   "stage_vs": null,
   "state_condition": "new",
   "sm_ack": null,
   "lfr_ack": null,
   "sequence": null,
   "attempts": 0,
   "transaction": "TUnsuJgwsAWoV5Vm",
   "player_transaction": "uhk1ZqU7bKsDenvz",
   "server": null,
   "duration": 73,
   "by_whom": "Adrians iPhone - 6.0.10 (8280) #881c8812",
   "diagnostic": false,
   "debug": "",
   "target": "camera",
   "target_id": 259335,
   "parent_command_id": null,
   "camera_id": 259335,
   "siren_id": null,
   "firmware_id": null,
   "network_id": 116468,
   "account_id": 97998,
   "sync_module_id": 207919
} 
```



## GET https://rest-{region.tier}.immedia-semi.com/network/{networkId}/command/{commandId}

#### Request Headers
 - token-auth: asdytas7d7asda3rdsda32

#### Response Headers
 - content-type: application/json

#### Response Body
 ```
{
   "complete": true,
   "status": 0,
   "status_msg": "Command succeeded",
   "status_code": 908,
   "commands": [
      {
         "id": 93856369,
         "created_at": "2020-06-01T15:35:21+00:00",
         "updated_at": "2020-06-01T15:35:23+00:00",
         "execute_time": "2020-06-01T15:35:21+00:00",
         "command": "temp_calibrate",
         "state_stage": "dev",
         "stage_rest": "2020-06-01T15:35:21+00:00",
         "stage_cs_db": "2020-06-01T15:35:21+00:00",
         "stage_cs_sent": "2020-06-01T15:35:21+00:00",
         "stage_sm": "2020-06-01T15:35:21+00:00",
         "stage_dev": "2020-06-01T15:35:23+00:00",
         "stage_is": null,
         "stage_lv": null,
         "stage_vs": null,
         "state_condition": "done",
         "sm_ack": 1,
         "lfr_ack": 0,
         "sequence": 472,
         "attempts": 0,
         "transaction": "TUnsuJgwsAWoV5Vm",
         "player_transaction": "uhk1ZqU7bKsDenvz",
         "server": null,
         "duration": 73,
         "by_whom": "Adrians iPhone - 6.0.10 (8280) #881c8812",
         "diagnostic": false,
         "debug": "{\"lfr_ok\":[116468,1,472,203,151,155,177,0]}",
         "target": "camera",
         "target_id": 259335,
         "parent_command_id": null,
         "camera_id": 259335,
         "siren_id": null,
         "firmware_id": null,
         "network_id": 116468,
         "account_id": 97998,
         "sync_module_id": 207919
      }
   ],
   "media_id": null
} 
```



## GET https://rest-{region.tier}.immedia-semi.com/api/v1/accounts/{accountId}/networks/{networkId}/cameras/{cameraId}/motion_regions

#### Request Headers
 - token-auth: asdytas7d7asda3rdsda32

#### Response Headers
 - content-type: application/json

#### Response Body
 ```
{
   "motion_regions": 33554431,
   "advanced_motion_regions": [
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095
   ]
} 
```



## POST https://rest-{region.tier}.immedia-semi.com/api/v1/accounts/{accountId}/networks/{networkId}/cameras/{cameraId}/motion_regions

#### Request Headers
 - token-auth: asdytas7d7asda3rdsda32

#### Request Body
 ```
{
   "advanced_motion_regions": [
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095
   ],
   "motion_regions": 33554431
} 
```

#### Response Headers
 - content-type: application/json

#### Response Body
 ```
{
   "message": "Successfully Updated Motion Regions for 259335",
   "motion_regions": 33554431,
   "advanced_motion_regions": [
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095,
      4095
   ],
   "id": 93856450,
   "network_id": 116468
} 
```



## POST https://rest-{region.tier}.immedia-semi.com/network/{networkId}/camera/{cameraId}/status

#### Request Headers
 - token-auth: asdytas7d7asda3rdsda32

#### Response Headers
 - content-type: application/json

#### Response Body
 ```
{
   "id": 93856547,
   "created_at": "2020-06-01T15:35:49+00:00",
   "updated_at": "2020-06-01T15:35:49+00:00",
   "execute_time": "2020-06-01T15:35:49+00:00",
   "command": "status",
   "state_stage": "rest",
   "stage_rest": "2020-06-01T15:35:49+00:00",
   "stage_cs_db": null,
   "stage_cs_sent": null,
   "stage_sm": null,
   "stage_dev": null,
   "stage_is": null,
   "stage_lv": null,
   "stage_vs": null,
   "state_condition": "new",
   "sm_ack": null,
   "lfr_ack": null,
   "sequence": null,
   "attempts": 0,
   "transaction": "zoJhNU02NhZ--krv",
   "player_transaction": "CDKGHmEdzWyAf-e1",
   "server": null,
   "duration": null,
   "by_whom": "Adrians iPhone - 6.0.10 (8280) #881c8812",
   "diagnostic": false,
   "debug": "",
   "target": null,
   "target_id": null,
   "parent_command_id": null,
   "camera_id": 259335,
   "siren_id": null,
   "firmware_id": null,
   "network_id": 116468,
   "account_id": 97998,
   "sync_module_id": 207919
} 
```



## POST https://rest-{region.tier}.immedia-semi.com/network/{networkId}/camera/{cameraId}/update

#### Request Headers
 - token-auth: asdytas7d7asda3rdsda32

#### Request Body
 ```
{
   "video_length": 30,
   "video_quality": "best",
   "record_audio_enable": true,
   "early_termination": true,
   "illuminator_enable": 2,
   "illuminator_intensity": 4,
   "lfr_sync_interval": 7,
   "name": "hallway",
   "early_notification": false,
   "motion_sensitivity": 6,
   "motion_alert": true,
   "alert_interval": 10
} 
```

#### Response Headers
 - content-type: application/json

#### Response Body
 ```
{
   "id": 93856586,
   "created_at": "2020-06-01T15:35:57+00:00",
   "updated_at": "2020-06-01T15:35:57+00:00",
   "execute_time": "2020-06-01T15:35:57+00:00",
   "command": "config_set",
   "state_stage": "rest",
   "stage_rest": "2020-06-01T15:35:57+00:00",
   "stage_cs_db": null,
   "stage_cs_sent": null,
   "stage_sm": null,
   "stage_dev": null,
   "stage_is": null,
   "stage_lv": null,
   "stage_vs": null,
   "state_condition": "done",
   "sm_ack": null,
   "lfr_ack": null,
   "sequence": null,
   "attempts": 0,
   "transaction": "OXpI7JRD060mMdf4",
   "player_transaction": "VFj_-EL4s3aJj9TM",
   "server": null,
   "duration": null,
   "by_whom": "Adrians iPhone - 6.0.10 (8280) #881c8812",
   "diagnostic": false,
   "debug": "",
   "target": "camera",
   "target_id": 259335,
   "parent_command_id": null,
   "camera_id": 259335,
   "siren_id": null,
   "firmware_id": null,
   "network_id": 116468,
   "account_id": 97998,
   "sync_module_id": 207919
} 
```



## POST https://rest-{region.tier}.immedia-semi.com/network/{networkId}/camera/{cameraId}/thumbnail

#### Request Headers
 - token-auth: asdytas7d7asda3rdsda32

#### Response Headers
 - content-type: application/json

#### Response Body
 ```
{
   "id": 93856603,
   "created_at": "2020-06-01T15:36:00+00:00",
   "updated_at": "2020-06-01T15:36:00+00:00",
   "execute_time": "2020-06-01T15:36:00+00:00",
   "command": "thumbnail",
   "state_stage": "rest",
   "stage_rest": "2020-06-01T15:36:00+00:00",
   "stage_cs_db": null,
   "stage_cs_sent": null,
   "stage_sm": null,
   "stage_dev": null,
   "stage_is": null,
   "stage_lv": null,
   "stage_vs": null,
   "state_condition": "new",
   "sm_ack": null,
   "lfr_ack": null,
   "sequence": null,
   "attempts": 0,
   "transaction": "8oKFKBDzrKlGEOwo",
   "player_transaction": "AMK4pvqvtzgu9dsJ",
   "server": null,
   "duration": null,
   "by_whom": "Adrians iPhone - 6.0.10 (8280) #881c8812",
   "diagnostic": false,
   "debug": "",
   "target": "camera",
   "target_id": 259335,
   "parent_command_id": null,
   "camera_id": 259335,
   "siren_id": null,
   "firmware_id": null,
   "network_id": 116468,
   "account_id": 97998,
   "sync_module_id": 207919
} 
```



## GET https://rest-{region.tier}.immedia-semi.com/media/e001/account/{accountId}/network/{networkId}/camera/{cameraId}/thumbnail/fw_7.96__bErKuR9D_2020_06_01__15_36PM.jpg

#### Request Headers
 - token-auth: asdytas7d7asda3rdsda32

#### Response Headers
 - content-type: image/jpeg



## POST https://rest-{region.tier}.immedia-semi.com/api/v5/accounts/{accountId}/networks/{networkId}/cameras/{cameraId}/liveview

#### Request Headers
 - token-auth: asdytas7d7asda3rdsda32

#### Request Body
 ```
{
   "intent": "liveview",
   "motion_event_start_time": ""
} 
```

#### Response Headers
 - content-type: application/json

#### Response Body
 ```
{
   "command_id": 93856660,
   "join_available": true,
   "join_state": "available",
   "server": "immis://18.156.199.185:443/_34c3rs56rdgdfsdfs?client_id=47",
   "duration": null,
   "continue_interval": 30,
   "continue_warning": 10,
   "submit_logs": true,
   "new_command": true,
   "media_id": null,
   "options": {}
} 
```



## POST https://rest-{region.tier}.immedia-semi.com/api/v1/accounts/{accountId}/networks/{networkId}/state/arm

#### Request Headers
 - token-auth: asdytas7d7asda3rdsda32

#### Response Headers
 - content-type: application/json

#### Response Body
 ```
{
   "id": 93856803,
   "network_id": 116468,
   "command": "arm",
   "state": "new",
   "commands": [
      {
         "id": 93856804,
         "network_id": 116468,
         "command": "config_lfr",
         "state": "running"
      }
   ]
} 
```



## POST https://rest-{region.tier}.immedia-semi.com/api/v1/accounts/{accountId}/networks/{networkId}/state/disarm

#### Request Headers
 - token-auth: asdytas7d7asda3rdsda32

#### Response Headers
 - content-type: application/json

#### Response Body
 ```
{
   "id": 93856856,
   "network_id": 116468,
   "command": "disarm",
   "state": "new",
   "commands": [
      {
         "id": 93856857,
         "network_id": 116468,
         "command": "config_lfr",
         "state": "running"
      }
   ]
} 
```



## GET https://rest-{region.tier}.immedia-semi.com/api/v2/accounts/{accountId}/media/thumb/319915377_s.jpg

#### Request Headers
 - token-auth: asdytas7d7asda3rdsda32

#### Response Headers
 - content-type: image/jpeg



## POST https://rest-{region.tier}.immedia-semi.com/api/v1/accounts/{accountId}/media/delete

#### Request Headers
 - token-auth: asdytas7d7asda3rdsda32

#### Request Body
 ```
{
   "media_list": [
      310782995
   ]
} 
```

#### Response Headers
 - content-type: application/json

#### Response Body
 ```
{
   "message": "Successfully deleted videos",
   "code": 711
} 
```



## POST https://rest-{region.tier}.immedia-semi.com/api/v1/account/video_options

#### Request Headers
 - token-auth: asdytas7d7asda3rdsda32

#### Request Body
 ```
{
   "auto_purge_days": 30
} 
```

#### Response Headers
 - content-type: application/json

#### Response Body
 ```
{
   "id": 97998,
   "created_at": "2020-02-09T20:00:40+00:00",
   "updated_at": "2020-06-01T15:36:48+00:00",
   "last_app_activity": "2020-06-01",
   "country_code": null,
   "phone_number": null,
   "auto_purge_days": 30,
   "refresh_count": 0,
   "power_user": false,
   "feature_plan_id": null
} 
```



## GET https://rest-{region.tier}.immedia-semi.com/api/v2/accounts/{accountId}/media/clip/335071002.mp4

#### Request Headers
 - token-auth: asdytas7d7asda3rdsda32

#### Response Headers
 - content-type: video/mp4



## POST https://rest-{region.tier}.immedia-semi.com/api/v1/networks/{networkId}/programs/{programId}/disable

#### Request Headers
 - token-auth: asdytas7d7asda3rdsda32

#### Response Headers
 - content-type: application/json

#### Response Body
 ```
{
   "message": "Successfully disabled program 26830",
   "code": 803
} 
```



## POST https://rest-{region.tier}.immedia-semi.com/api/v1/networks/{networkId}/programs/{programId}/enable

#### Request Headers
 - token-auth: asdytas7d7asda3rdsda32

#### Response Headers
 - content-type: application/json

#### Response Body
 ```
{
   "message": "Successfully enabled program 26830",
   "code": 802
} 
```



## POST https://rest-{region.tier}.immedia-semi.com/network/{networkId}/update

#### Request Headers
 - token-auth: asdytas7d7asda3rdsda32

#### Request Body
 ```
{
   "lv_save": false
} 
```

#### Response Headers
 - content-type: application/json

#### Response Body
 ```
{
   "network": {
      "id": 116468,
      "created_at": "2020-02-09T20:01:14+00:00",
      "updated_at": "2020-06-01T15:36:35+00:00",
      "deleted_at": null,
      "name": "Home",
      "network_key": "lD-3GAN18jf-ELgc",
      "description": "",
      "network_origin": "normal",
      "locale": "",
      "time_zone": "Europe/Bucharest",
      "dst": true,
      "ping_interval": 60,
      "encryption_key": null,
      "armed": false,
      "autoarm_geo_enable": false,
      "autoarm_time_enable": false,
      "lv_mode": "relay",
      "lfr_channel": 0,
      "video_destination": "server",
      "storage_used": 0,
      "storage_total": 0,
      "video_count": 0,
      "video_history_count": 4000,
      "arm_string": "Disarmed",
      "busy": false,
      "camera_error": false,
      "sync_module_error": false,
      "feature_plan_id": null,
      "account_id": 97998,
      "lv_save": false
   }
} 
```



