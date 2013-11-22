class CreateResources < ActiveRecord::Migration
  def change
    create_table :resources do |t|
      t.string :name
      t.text :description
      t.integer :school_id
      t.integer :request_id
      t.string :image_url
      t.boolean :fulfilled
    end
  end
end
