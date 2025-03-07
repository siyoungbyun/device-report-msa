
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import ReportDeviceReportManager from "./components/listers/ReportDeviceReportCards"
import ReportDeviceReportDetail from "./components/listers/ReportDeviceReportDetail"

import ReportDashboardView from "./components/ReportDashboardView"
import ReportDashboardViewDetail from "./components/ReportDashboardViewDetail"
import DeviceDeviceManager from "./components/listers/DeviceDeviceCards"
import DeviceDeviceDetail from "./components/listers/DeviceDeviceDetail"

import DeviceDashboardView from "./components/DeviceDashboardView"
import DeviceDashboardViewDetail from "./components/DeviceDashboardViewDetail"
import NotificationNotificationHistoryManager from "./components/listers/NotificationNotificationHistoryCards"
import NotificationNotificationHistoryDetail from "./components/listers/NotificationNotificationHistoryDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/reports/deviceReports',
                name: 'ReportDeviceReportManager',
                component: ReportDeviceReportManager
            },
            {
                path: '/reports/deviceReports/:id',
                name: 'ReportDeviceReportDetail',
                component: ReportDeviceReportDetail
            },

            {
                path: '/reports/reportDashboards',
                name: 'ReportDashboardView',
                component: ReportDashboardView
            },
            {
                path: '/reports/reportDashboards/:id',
                name: 'ReportDashboardViewDetail',
                component: ReportDashboardViewDetail
            },
            {
                path: '/devices/devices',
                name: 'DeviceDeviceManager',
                component: DeviceDeviceManager
            },
            {
                path: '/devices/devices/:id',
                name: 'DeviceDeviceDetail',
                component: DeviceDeviceDetail
            },

            {
                path: '/devices/deviceDashboards',
                name: 'DeviceDashboardView',
                component: DeviceDashboardView
            },
            {
                path: '/devices/deviceDashboards/:id',
                name: 'DeviceDashboardViewDetail',
                component: DeviceDashboardViewDetail
            },
            {
                path: '/notifications/notificationHistories',
                name: 'NotificationNotificationHistoryManager',
                component: NotificationNotificationHistoryManager
            },
            {
                path: '/notifications/notificationHistories/:id',
                name: 'NotificationNotificationHistoryDetail',
                component: NotificationNotificationHistoryDetail
            },



    ]
})
