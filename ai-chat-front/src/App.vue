<template>
  <div class="common-layout">
    <el-container v-if="state.showMenu">
      
      <el-aside width="200px">
        <el-input
          class="menu-search"
          placeholder="搜索"
          :prefix-icon="Search"
        />
        <el-menu
          class="el-menu-vertical-demo"
          background-color="#0f2e50"
          text-color="#fff"
          router
        >
          <el-sub-menu index="1">
            <template #title>
              <el-icon><location /></el-icon>
              <span>Navigator One</span>
            </template>
            <el-menu-item index="/">item one</el-menu-item>
            <el-menu-item index="/">item two</el-menu-item>
            <el-menu-item index="/">item three</el-menu-item>
            <el-menu-item index="/">item four</el-menu-item>
          </el-sub-menu>
          <el-sub-menu index="2">
            <template #title>
              <el-icon><location /></el-icon>
              <span>Navigator Two</span>
            </template>
            <el-menu-item index="/">item one</el-menu-item>
            <el-menu-item index="/">item two</el-menu-item>
            <el-menu-item index="/">item three</el-menu-item>
            <el-menu-item index="/">item four</el-menu-item>
          </el-sub-menu>
          <el-sub-menu index="3">
            <template #title>
              <el-icon><document /></el-icon>
              <span>Navigator Three</span>
            </template>
            <el-menu-item index="/">item one</el-menu-item>
            <el-menu-item index="/">item two</el-menu-item>
            <el-menu-item index="/">item three</el-menu-item>
            <el-menu-item index="/">item four</el-menu-item>
          </el-sub-menu>
          <el-sub-menu index="4">
            <template #title>
              <el-icon><document /></el-icon>
              <span>Navigator Four</span>
            </template>
            <el-menu-item index="/">item one</el-menu-item>
            <el-menu-item index="/">item two</el-menu-item>
            <el-menu-item index="/">item three</el-menu-item>
            <el-menu-item index="/">item four</el-menu-item>
          </el-sub-menu>
        </el-menu>
      </el-aside>

      <el-container>

        <el-header>Header</el-header>

        <el-main>
          <router-view/>
        </el-main>


        <el-footer>Footer</el-footer>

      </el-container>

    </el-container>

    <el-container v-else>
      <router-view />
    </el-container>
  </div>
</template>

<script setup>
  import { useRouter } from 'vue-router'
  import {ref, reactive} from 'vue'
  import { Search } from '@element-plus/icons-vue'


  // 不需要菜单的路径数组
  const noMenu = ['/login']
  const router = useRouter()

  const state = reactive({
    showMenu: false, // 是否需要显示菜单
  })

  router.beforeEach((to) => {
    state.showMenu = !noMenu.includes(to.path)
  })

  const debounce = (fn, delay) => {

    let timer = null;

    return function () {

      let context = this;

      let args = arguments;

      clearTimeout(timer);

      timer = setTimeout(function () {

        fn.apply(context, args);

      }, delay);

    }

  }

// 解决ERROR ResizeObserver loop completed with undelivered notifications.

//问题的

  const _ResizeObserver = window.ResizeObserver;

  window.ResizeObserver = class ResizeObserver extends _ResizeObserver {

    constructor(callback) {

      callback = debounce(callback, 16);

      super(callback);

    }

  }
</script>

<style scoped>
  .common-layout {
    height: 100vh;
  }
  .el-container {
    height: 100vh;
  }
  .el-aside {
    background-color: #0f2e50;
  }
  .el-menu {
    border:0 !important;
  }
  .el-input .el-input__inner {
    background-color: #0f2e50;
}

</style>

<style>
html,body,#app {
  padding: 0;
  margin: 0;
  height: 100%;
  overflow: hidden;
}
</style>


