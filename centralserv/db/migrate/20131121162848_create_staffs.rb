class CreateStaffs < ActiveRecord::Migration
  def change
    create_table :staffs do |t|
      t.string :name
      t.string :image_url
      t.string :role
      t.integer :school_id
    end
  end
end
