# encoding: UTF-8
# This file is auto-generated from the current state of the database. Instead
# of editing this file, please use the migrations feature of Active Record to
# incrementally modify your database, and then regenerate this schema definition.
#
# Note that this schema.rb definition is the authoritative source for your
# database schema. If you need to create the application database on another
# system, you should be using db:schema:load, not running all the migrations
# from scratch. The latter is a flawed and unsustainable approach (the more migrations
# you'll amass, the slower it'll run and the greater likelihood for issues).
#
# It's strongly recommended that you check this file into your version control system.

ActiveRecord::Schema.define(version: 20131122020251) do

  create_table "curriculums", force: true do |t|
    t.integer "week"
    t.string  "title"
    t.text    "content"
    t.integer "grade_id"
  end

  create_table "curriculums_staffs", force: true do |t|
    t.integer "curriculum_id"
    t.integer "staff_id"
    t.string  "completed"
  end

  create_table "grades", force: true do |t|
    t.string "rank"
  end

  create_table "grades_staffs", force: true do |t|
  end

  create_table "messages", force: true do |t|
    t.string  "title"
    t.text    "content"
    t.string  "type"
    t.integer "staff_id"
  end

  create_table "notifications", force: true do |t|
    t.string  "title"
    t.text    "content"
    t.integer "school_id"
  end

  create_table "requests", force: true do |t|
    t.string  "name"
    t.text    "description"
    t.integer "school_id"
    t.string  "image_url"
  end

  create_table "requests_resources", force: true do |t|
    t.integer "resource_id"
    t.integer "request_id"
    t.text    "response"
  end

  create_table "resources", force: true do |t|
    t.string  "name"
    t.text    "description"
    t.integer "school_id"
    t.string  "image_url"
    t.boolean "fulfilled"
  end

  create_table "schools", force: true do |t|
    t.string "name"
    t.string "location"
  end

  create_table "staffs", force: true do |t|
    t.string  "name"
    t.string  "image_url"
    t.string  "role"
    t.integer "school_id"
  end

  create_table "students", force: true do |t|
    t.string   "name"
    t.integer  "age"
    t.string   "gender"
    t.string   "contact"
    t.integer  "grade_id"
    t.string   "staff_id"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

end
